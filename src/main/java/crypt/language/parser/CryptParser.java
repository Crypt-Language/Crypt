package crypt.language.parser;

import crypt.language.Crypt;
import crypt.language.lexer.token.Token;
import crypt.language.lexer.token.TokenType;
import crypt.language.parser.AST.Expression;

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
        return equality();
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

        else if (match(L_PAREN)) {
            Expression expr = expression();
            consume(R_PAREN, "Expect ')' after expression.");
            return new Expression.Grouping(expr);
        }
        else return null; //TODO: find a way to stop error
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
                case SET:
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

    public Expression parse() {
        try {
            return expression();
        } catch (ParseError error) {
            return null;
        }
    }

    private static class ParseError extends RuntimeException {

    }
}
