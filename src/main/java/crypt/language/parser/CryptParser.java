package crypt.language.parser;

import crypt.language.Crypt;
import crypt.language.lexer.token.Token;
import crypt.language.lexer.token.TokenType;
import crypt.language.parser.AST.Expression;
import crypt.language.parser.AST.Statement;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;

import static crypt.language.lexer.token.TokenType.*;

public class CryptParser {
    private final List<Token> tokens;
    private int current = 0;

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

        while (match(SLASH, ASTERISK)) {
            Token operator = previous();
            Expression right = unary();
            expr = new Expression.Binary(expr, operator, right);
        }

        return expr;
    }

    private Expression unary() {
        if (match(NOT, MINUS)) {
            Token operator = previous();
            Expression right = unary();
            return new Expression.Unary(operator, right);
        }

        return primary();
    }

    private Expression primary() {
        if (match(FALSE)) return new Expression.Literal(false);
        else if (match(TRUE)) return new Expression.Literal(true);
        else if (match(NIL)) return new Expression.Literal(null);

        else if (match(NUMBER, STRING)) {
            return new Expression.Literal(previous().literal);
        }

        else if (match(ID)) {
            return new Expression.Variable(previous());
        }

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
        if(match(TILDE) && match(L_BRACE)) return new Statement.Block(blockStatement());
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

        while (!check(R_BRACE) && !isAtEnd()) {
            statements.add(declaration());
        }

        consume(R_BRACE, "Expect '}' after block.");
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
        else error(peek(), message);
        return null; //TODO : null here as well
    }

    private ParseError error(Token token, String message) {
        Crypt.error(token.line, message);
        return new ParseError();
    }

    private void synchronize() {
        advance();

        while (!isAtEnd()) {
            if (previous().type == SEMICOLON) return;

            switch (peek().type) {
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

    private static class ParseError extends RuntimeException {

    }
}
