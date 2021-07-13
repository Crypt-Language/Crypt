package dev.aurumbyte.crypt.CryptCompiler.Parser;

import dev.aurumbyte.crypt.CryptCompiler.Lexer.token.Token;
import dev.aurumbyte.crypt.CryptCompiler.Lexer.token.TokenType;
import dev.aurumbyte.crypt.CryptCompiler.utils.EncoderCLI;
import dev.aurumbyte.crypt.CryptCompiler.utils.Expression;
import dev.aurumbyte.crypt.CryptCompiler.utils.Statement;

import java.util.ArrayList;
import java.util.List;


public class CryptParser {
    private static class ParseError extends RuntimeException {}

    private final List<Token> tokens;
    public int current = 0;

    public CryptParser(List<Token> tokens){
        this.tokens = tokens;
    }

    /*Expression Parsing*/
    private Expression expression(){
        return assignment();
    }

    private Expression assignment() {
        Expression expr = or();

        if (match(TokenType.COLON)) {
            Token equals = previous();
            Expression value = assignment();

            if (expr instanceof Expression.Variable) {
                Token name = ((Expression.Variable)expr).name;
                return new Expression.Assign(name, value);
            }

            error(equals.line, "Invalid assignment target.");
        }

        return expr;
    }

    private Expression equality() {
        Expression expr = comparison();

        while (match(TokenType.EQUALS, TokenType.NOT_EQUAL)) {
            Token operator = previous();
            Expression right = comparison();
            expr = new Expression.Binary(expr, operator, right);
        }

        return expr;
    }

    private Expression comparison() {
        Expression expr = term();

        while (match(TokenType.GREATER_THAN, TokenType.GREATER_OR_EQUAL, TokenType.LESS_THAN, TokenType.LESS_OR_EQUAL)) {
            Token operator = previous();
            Expression right = term();
            expr = new Expression.Binary(expr, operator, right);
        }

        return expr;
    }

    private Expression term() {
        Expression expr = factor();

        while (match(TokenType.MINUS, TokenType.PLUS)) {
            Token operator = previous();
            Expression right = factor();
            expr = new Expression.Binary(expr, operator, right);
        }

        return expr;
    }

    private Expression factor() {
        Expression expr = unary();

        while (match(TokenType.SLASH, TokenType.ASTERISK)) {
            Token operator = previous();
            Expression right = unary();
            expr = new Expression.Binary(expr, operator, right);
        }

        return expr;
    }

    private Expression unary() {
        if (match(TokenType.NOT, TokenType.MINUS)) {
            Token operator = previous();
            Expression right = unary();
            return new Expression.Unary(operator, right);
        }

        return call();
    }

    private Expression call() {
        Expression expr = primary();

        while (true) {
            if (match(TokenType.L_PAREN)) {
                expr = finishCall(expr);
            } else {
                break;
            }
        }

        return expr;
    }

    private Expression finishCall(Expression callee) {
        List<Expression> arguments = new ArrayList<>();
        if (!check(TokenType.R_PAREN)) {
            do {
                arguments.add(expression());
            } while (match(TokenType.COMMA));
        }

        Token paren = consumeWithError(TokenType.R_PAREN, "Expect ')' after arguments.");

        return new Expression.Call(callee, paren, arguments);
    }

    private Expression primary() {
        if (match(TokenType.FALSE)) return new Expression.Literal(false);
        if (match(TokenType.TRUE)) return new Expression.Literal(true);
        if (match(TokenType.NIL)) return new Expression.Literal(null);

        if (match(TokenType.NUMBER, TokenType.STRING)) {
            return new Expression.Literal(previous().literal);
        }

        if (match(TokenType.L_PAREN)) {
            Expression expr = expression();
            consumeWithError(TokenType.R_PAREN, "Expect ')' after expression.");
            return new Expression.Grouping(expr);
        }

        if (match(TokenType.ID)) {
            return new Expression.Variable(previous());
        }

        throw error(peek().line, "Expecting expression.");
    }

    private Expression or(){
        Expression expr = and();

        while (match(TokenType.OR)) {
            Token operator = previous();
            Expression right = and();
            expr = new Expression.Logical(expr, operator, right);
        }

        return expr;
    }

    private Expression and(){
        Expression expr = equality();

        while (match(TokenType.AND)) {
            Token operator = previous();
            Expression right = equality();
            expr = new Expression.Logical(expr, operator, right);
        }

        return expr;
    }

    /*Statement Parsing*/

    private Statement statement() {
        if (match(TokenType.PRINT)) return printStatement();
        if (match(TokenType.PRINTLN)) return printlnStatement();
        if (match(TokenType.BLOCK_OP)) return blockStatement();
        if (match(TokenType.WHILE)) return whileStatement();
        if (check(TokenType.Q_MARK)){
            return ifStatement();
        }

        return expressionStatement();
    }

    private Statement printStatement() {
        Expression value = expression();
        consumeWithError(TokenType.SEMICOLON, "Expect ';' after value.");
        return new Statement.Print(value);
    }

    private Statement printlnStatement() {
        Expression value = expression();
        consumeWithError(TokenType.SEMICOLON, "Expect ';' after value.");
        return new Statement.Println(value);
    }

    private Statement expressionStatement() {
        Expression expr = expression();
        consumeWithError(TokenType.SEMICOLON, "Expect ';' after expression.");
        return new Statement.ExpressionStatement(expr);
    }

    private Statement variableDeclaration() {
        Token name = consumeWithError(TokenType.ID, "Expect variable name.");

        Token type = null;
        if(match(TokenType.DB_COLON)) {
            //type = n
        }

        Expression initializer = null;
        if (match(TokenType.COLON)) {
            initializer = expression();
        }

        consumeWithError(TokenType.SEMICOLON, "Expect ';' after variable declaration.");
        return new Statement.VariableDeclaration(name, initializer, null);
    }

    private Statement blockStatement(){
        List<Statement> statements = new ArrayList<>();
/*
        if(check(TokenType.NEWLINE)) {
            consumeWithError(TokenType.INDENT, "A block must start with indent or '{' ");

            while (!check(TokenType.DEDENT) && !isAtEnd()) {
                statements.add(statement());
            }
        } else {
           statements.add(statement());
           consumeWithError(TokenType.DEDENT, "");
        }

 */

        if(check(TokenType.L_CURLY)) {
            consume();

            while (!check(TokenType.R_CURLY) && !isAtEnd()) {
                statements.add(statement());
            }
        } else {
            statements.add(statement());
        }

        consumeWithError(TokenType.R_CURLY, "If a block starts with a '{', it must end with a '}'");

        return new Statement.Block(statements);
    }

    private Statement ifStatement(){
        Expression expression = expression();
        Statement thenStatement = statement();

        Statement elseStatement = null;
        if(match(TokenType.ELSE)) {
            elseStatement = statement();
        }

        return new Statement.If(expression, thenStatement, elseStatement);
    }

    private Statement whileStatement(){
        consumeWithError(TokenType.L_PAREN, "Expect '(' after 'while'.");
        Expression condition = expression();
        consumeWithError(TokenType.R_PAREN, "Expect ')' after condition.");
        Statement body = statement();

        return new Statement.While(condition, body);
    }

    /*Helper functions*/
    private boolean match(TokenType... types) {
        for (TokenType type : types) {
            if (check(type)) {
                consume();
                return true;
            }
        }

        return false;
    }

    private boolean check(TokenType type) {
        if (isAtEnd()) return false;
        return peek().type == type;
    }

    private Token consume() {
        if (!isAtEnd()) current++;
        return previous();
    }

    private boolean isAtEnd() {
        return peek().type == TokenType.EOF;
    }

    private Token peek() {
        return tokens.get(current);
    }

    private Token previous() {
        return tokens.get(current - 1);
    }

    private Token previous(int i){
        return tokens.get(current - i);
    }

    private ParseError error(int line, String message) {
        EncoderCLI.error(line, message);
        return new ParseError();
    }

    private Token consumeWithError(TokenType type, String message) {
        if (check(type)) return consume();
        else throw error(peek().line, message);
    }

    private void synchronize() {
        consume();

        while (!isAtEnd()) {
            if (previous().type == TokenType.SEMICOLON) return;

            switch (peek().type) {
                case CLASS:
                case FN:
                case FOR:
                case WHILE:
                case PRINT:
                case RETURN:
                    return;
            }

            consume();
        }
    }

   public List<Statement> parse() {
        List<Statement> statements = new ArrayList<>();
        while (!isAtEnd()) {
            statements.add(statement());
        }

        return statements;
    }
}