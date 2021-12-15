package crypt.language.parser;

import crypt.language.Crypt;
import crypt.language.error.Errors;
import crypt.language.lexer.token.Token;
import crypt.language.lexer.token.TokenType;
import crypt.language.parser.AST.Expression;
import crypt.language.parser.AST.Statement;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static crypt.language.lexer.token.TokenType.*;

public class CryptParser {
    private final List<Token> tokens;
    private int current = 0;
    public boolean parseError = false;

    public CryptParser(List<Token> tokens) {
        this.tokens = tokens;
    }

    /*
     * ===============================
     * Expression Parser
     * ===============================
     */

    private Expression expression() {
        return assignment();
    }

    private Expression assignment() {
        Expression expr = or();

        if (match(COLON)) {
            Token equals = previous();
            Expression value = assignment();

            if (expr instanceof Expression.Variable) {
                Token name = ((Expression.Variable)expr).name;
                return new Expression.Assignment(name, value);
            } else if (expr instanceof Expression.Get) {
                Expression.Get get = (Expression.Get)expr;
                return new Expression.Set(get.object, get.name, value);
            }

            error(equals, "Invalid assignment target.");
        }

        return expr;
    }

    private Expression or() {
        Expression expr = and();

        while (match(OR)) {
            Token operator = previous();
            Expression right = and();
            expr = new Expression.Logical(expr, operator, right);
        }

        return expr;
    }

    private Expression and() {
        Expression expr = equality();

        while (match(AND)) {
            Token operator = previous();
            Expression right = equality();
            expr = new Expression.Logical(expr, operator, right);
        }

        return expr;
    }

    private Expression equality() {
        Expression expr = comparison();

        while (match(NOT_EQUAL, EQUALS)) {
            Token operator = previous();
            Expression right = comparison();
            expr = new Expression.Binary(expr, operator, right);
        }

        return expr;
    }

    private Expression comparison() {
        Expression expr = term();

        while (match(GREATER, GREATER_OR_EQUAL, LESS, LESS_OR_EQUAL)) {
            Token operator = previous();
            Expression right = term();
            expr = new Expression.Binary(expr, operator, right);
        }

        return expr;
    }

    private Expression term() {
        Expression expr = factor();

        while (match(MINUS, PLUS)) {
            Token operator = previous();
            Expression right = factor();
            expr = new Expression.Binary(expr, operator, right);
        }

        return expr;
    }

    private Expression factor() {
        Expression expr = unary();

        while (match(SLASH, ASTERISK, POW)) {
            Token operator = previous();
            Expression right = unary();
            expr = new Expression.Binary(expr, operator, right);
        }

        return expr;
    }

    private Expression unary() {
        if (match(NOT, MINUS, ROOT)) {
            Token operator = previous();
            Expression right = unary();
            return new Expression.Unary(operator, right);
        }

        return call();
    }

    private Expression call(){
        Expression expr = primary();

        while (true) {
            if (match(L_PAREN)) {
                expr = finishCall(expr);
            } else if (match(DOT)) {
                Token name = consume(ID, "Expect property name after '.'.");
                expr = new Expression.Get(expr, name);
            } else {
                break;
            }
        }

        return expr;
    }

    private Expression primary() {
        if (match(FALSE)) return new Expression.Literal(false);
        else if (match(TRUE)) return new Expression.Literal(true);
        else if (match(NIL)) return new Expression.Literal(null);
        else if (match(NUMBER, STRING)) return new Expression.Literal(previous().literal);

        if (match(SUPER)) {
            Token keyword = previous();
            consume(DOT, "Expect '.' after 'super'.");
            Token method = consume(ID, "Expect superclass method name.");
            return new Expression.Super(keyword, method);
        }


        if (match(THIS)) return new Expression.This(previous());

        else if (match(ID)) return new Expression.Variable(previous());


        else if (match(L_PAREN)) {
            Expression expr = expression();
            consume(R_PAREN, "Expect ')' after expression.");
            return new Expression.Grouping(expr);
        }
        else return null; //TODO: find a way to stop error
    }

    /*
    * ================================
    * Statement Parsing
    * ================================
    */

    private Statement declaration() {
        try {
            if (match(LET)) return variableDeclaration();
            if (match(FN)) return function("function");
            if (match(TYPE)) return classDeclaration();
            return statement();
        } catch (ParseError error) {
            synchronize();
            return null;
        }
    }

    private Statement statement() {
        if(match(PRINT)) return printStatement();
        if(match(PRINTLN)) return printlnStatement();
        if(match(IF)) return ifStatement();
        if(match(WHILE)) return whileStatement();
        if(match(ARROW_RIGHT_BIG)) return new Statement.Block(blockStatement());
        if(match(FOR)) return forStatement();
        if(match(RETURN)) return returnStatement();
        if(match(INPUT)) return inputStatement();
        return expressionStatement();
    }


    private Statement printStatement() {
        Expression value = expression();
        consume(SEMICOLON, "Expect ';' after value.");
        return new Statement.Print(value);
    }

    private Statement printlnStatement() {
        Expression value = expression();
        consume(SEMICOLON, "Expect ';' after value.");
        return new Statement.Println(value);
    }

    private Statement inputStatement() {
        Expression value = expression();
        consume(SEMICOLON, "Expect ';' after value.");
        return new Statement.Input(value);
    }

    private Statement expressionStatement() {
        Expression expr = expression();
        consume(SEMICOLON, "Expect ';' after expression.");
        return new Statement.ExpressionStatement(expr);
    }

    private Statement variableDeclaration() {
        Token name = consume(ID, "Expect variable name.");

        Expression initializer = null;
        if (match(COLON)) {
            initializer = expression();
        }

        consume(SEMICOLON, "Expect ';' after variable declaration.");
        return new Statement.Variable(name, initializer);
    }

    private List<Statement> blockStatement(){
        List<Statement> statements = new ArrayList<>();

        if(match(L_BRACE)) {
            while (!check(R_BRACE) && !isAtEnd()) {
                statements.add(declaration());
            }

            consume(R_BRACE, "Expect '}' after block.");
        } else {
            statements.add(declaration());
        }
        return statements;
    }

    private Statement ifStatement(){
        Expression condition = expression();

        Statement thenBranch = statement();
        Statement elseBranch = null;

        if (match(ELSE)) elseBranch = statement();


        return new Statement.If(condition, thenBranch, elseBranch);
    }

    private Statement whileStatement(){
        Expression condition = expression();
        Statement body = statement();

        return new Statement.While(condition, body);
    }

    private Statement forStatement(){
        //initializer
        Statement initializer;
        if (match(SEMICOLON)) {
            initializer = null;
        } else if (match(LET)) {
            initializer = variableDeclaration();
        } else {
            initializer = expressionStatement();
        }


        //condition
        Expression condition = null;
        if (!check(SEMICOLON)) {
            condition = expression();
        }
        consume(SEMICOLON, "Expect ';' after loop condition.");

        //increment
        Expression increment = null;
        if (!check(R_PAREN)) {
            increment = expression();
        }

        //body
        Statement body = statement();

        if (increment != null) {
            body = new Statement.Block(
                    Arrays.asList(
                            body,
                            new Statement.ExpressionStatement(increment)
                    )
            );
        }

        if (condition == null) condition = new Expression.Literal(true);
        body = new Statement.While(condition, body);

        if (initializer != null) body = new Statement.Block(Arrays.asList(initializer, body));

        return body;
    }

    private Statement.Function function(String kind) {
        Token name = consume(ID, "Expect " + kind + " name.");

        consume(L_PAREN, "Expect '(' after " + kind + " name.");

        List<Token> parameters = new ArrayList<>();
        if (!check(R_PAREN)) {
            do {
                if (parameters.size() >= 255) error(peek(), "Can't have more than 255 parameters.");
                parameters.add(consume(ID, "Expect parameter name."));
            } while (match(COMMA));
        }

        consume(R_PAREN, "Expect ')' after parameters.");

        consume(ARROW_RIGHT_BIG, "Expect '=>' before " + kind + " body.");
        List<Statement> body = blockStatement();
        return new Statement.Function(name, parameters, body);
    }

    private Statement returnStatement() {
        Token keyword = previous();
        Expression value = null;
        if (!check(SEMICOLON)) value = expression();

        consume(SEMICOLON, "Expect ';' after return value.");
        return new Statement.Return(keyword, value);
    }

    private Statement classDeclaration(){
        Token name = consume(ID, "Expect class name.");

        Expression.Variable superclass = null;
        if (match(DB_COLON)) {
            consume(ID, "Expect superclass name.");
            superclass = new Expression.Variable(previous());
        }

        consume(ARROW_RIGHT_BIG, "Expect '=>' before block class body.");
        consume(L_BRACE, "Expect '{' before class body.");

        List<Statement.Function> methods = new ArrayList<>();
        while (!check(R_BRACE) && !isAtEnd()) {
            methods.add(function("method"));
        }

        consume(R_BRACE, "Expect '}' after class body.");

        return new Statement.Class(name, superclass, methods);
    }

    /*
     * ================================
     * Helper Functions
     * ================================
     */

    private boolean match(TokenType... types) {
        for (TokenType type : types) {
            if (check(type)) {
                advance();
                return true;
            }
        }

        return false;
    }

    private boolean check(TokenType type) {
        if (isAtEnd()) return false;
        return peek().type == type;
    }

    private Token advance() {
        if (!isAtEnd()) current++;
        return previous();
    }

    private boolean isAtEnd() {
        return peek().type == EOF;
    }

    private Token peek() {
        return tokens.get(current);
    }

    private Token previous() {
        return tokens.get(current - 1);
    }

    private Token consume(TokenType type, String message) {
        if (check(type)) return advance();

        error(peek(), message);
        parseError = true;
        return advance();
    }

    private void error(Token token, String message) {
        Errors.report(2, token.lexeme, token.line);
        throw new ParseError(message);
    }

    private void synchronize() {
        advance();

        while (!isAtEnd()) {
            if (previous().type == SEMICOLON) return;

            switch (Objects.requireNonNull(peek().type)) {
                case TYPE:
                case FN:
                case LET:
                case FOR:
                case IF:
                case WHILE:
                case PRINT:
                case RETURN:
                    return;
            }

            advance();
        }
    }

    public List<Statement> parse() {
        List<Statement> statements = new ArrayList<>();
        while (!isAtEnd()) {
            statements.add(declaration());
        }

        return statements;
    }

    private Expression finishCall(Expression callee) {
        List<Expression> arguments = new ArrayList<>();
        if (!check(R_PAREN)) {
            do {
                if (arguments.size() >= 255) error(peek(), "Can't have more than 255 arguments.");
                arguments.add(expression());
            } while (match(COMMA));
        }

        Token paren = consume(R_PAREN, "Expect ')' after arguments.");

        return new Expression.Call(callee, paren, arguments);
    }

    private static class ParseError extends RuntimeException {
        public ParseError(String message){
            super(message);
        }
    }
}
