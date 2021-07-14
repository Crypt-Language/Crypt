package dev.aurumbyte.crypt.CryptCompiler.Lexer;

import dev.aurumbyte.crypt.CryptCompiler.Lexer.token.Token;
import dev.aurumbyte.crypt.CryptCompiler.Lexer.token.TokenType;
import dev.aurumbyte.crypt.CryptCompiler.utils.EncoderCLI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CryptLexer {
    private final String input;
    private final List<Token> tokens = new ArrayList<>();
    private int start = 0;
    private int current = 0;
    private int line = 1;

    private final List<Integer> indentStack = new ArrayList<>();
    private int indentLevel;

    public CryptLexer(String input) {
        this.input = input;
    }

    public List<Token> lex() throws Exception {
        while (!isAtEnd()) {
            char c = consume();
            start = current;
            scanToken(c);
        }
        indentStack.add(0);
        tokens.add(new Token(TokenType.EOF, "End Of File", null, line));
        return tokens;
    }

    private void scanToken(char c) throws Exception {
        switch (c) {
            case ' ': newToken(TokenType.WHITESPACE); break;
            case '\t': newToken(TokenType.WHITESPACE, "/t"); break;
            case '\r': newToken(TokenType.WHITESPACE, "/r"); break;
            case '(': newToken(TokenType.L_PAREN); break;
            case ')': newToken(TokenType.R_PAREN); break;
            case '{': newToken(TokenType.L_CURLY); break;
            case '}': newToken(TokenType.R_CURLY); break;
            case ',': newToken(TokenType.COMMA); break;
            case '.': newToken(TokenType.DOT); break;

            case '-':
                newToken(match('>') ? TokenType.RIGHT_ARROW : TokenType.MINUS);
                break;

            case '+': newToken(TokenType.PLUS); break;
            case ';': newToken(TokenType.SEMICOLON); break;
            case '*': newToken(TokenType.ASTERISK); break;
            case '=': newToken(TokenType.EQUALS); break;
            case '?': newToken(TokenType.Q_MARK); break;

            case '!':
                if (match('=')) newToken(TokenType.NOT_EQUAL);
                else throw new Exception("! isn't supported for expressions. Try 'not' instead");
                break;

            case '<':
                if (match('-')) newToken(TokenType.LEFT_ARROW);
                newToken(match('=') ? TokenType.LESS_OR_EQUAL : TokenType.LESS_THAN);
                break;

            case '>':
                if (match('>')) newToken(TokenType.BLOCK_OP);
                newToken(match('=') ? TokenType.GREATER_OR_EQUAL : TokenType.GREATER_THAN);
                break;

            case '/':
                if (match('/')) {
                    // A comment goes until the end of the line.
                    while (peek() != '\n' && !isAtEnd()) consume();
                } else {
                    newToken(TokenType.SLASH);
                }
                break;

            case '"' : string(); break;

            case '\n': {
                indentLevel = 0;
                while(peek() == ' ') indentLevel++;
                indent(indentLevel);
            }

            default:
                if(isDigit(c)){ number();}
                else if(isAlpha(c)){ identifier();}
                else {
                    EncoderCLI.error(line, "Unexpected character '" + c + "'");}
                break;
        }
    }

    /*Helper Functions*/
    public void indent(int indentLevel){
        if(indentLevel > indentStack.get(indentStack.size() - 1)){
            newToken(TokenType.INDENT);
            indentStack.add(indentLevel);
        } else if (indentLevel < indentStack.get(indentStack.size() - 1)){
            while(indentLevel < indentStack.get(indentStack.size() - 1)) {
                newToken(TokenType.DEDENT);
                indentStack.remove(indentStack.size() - 1);

                if(indentStack.get(indentStack.size() - 1).equals(0)){
                    break;
                }
            }
        }
    }

    private boolean isAtEnd() {
        return current >= input.length();
    }

    private char consume() {
        return input.charAt(current++);
    }

    private void newToken(TokenType type) {
        newToken(type, null);
    }

    private void newToken(TokenType type, Object literal) {
        String text = input.substring(start, current);
        tokens.add(new Token(type, text, literal, line));
    }

    private boolean match(char expected) {
        if (isAtEnd()) return false;
        if (input.charAt(current) != expected) return false;

        current++;
        return true;
    }

    private char peek() {
        if (isAtEnd()) return '\0';
        return input.charAt(current);
    }

    private char peekNext() {
        if (current + 1 >= input.length()) return '\0';
        return input.charAt(current + 1);
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                c == '_';
    }

    private boolean isAlphaNumeric(char c) {
        return isAlpha(c) || isDigit(c);
    }

    private void string() {
        while (peek() != '"' && !isAtEnd() && peek() != '\n') {
            consume();
        }

        if (peek() == '\n'){
            EncoderCLI.error(line, "Crypt doesn't support multi-line strings.");
        }

        if (isAtEnd()) {
            EncoderCLI.error(line, "Unterminated string.");
            return;
        }

        consume();

        String value = input.substring(start + 1, current - 1);
        newToken(TokenType.STRING, value);
    }

    private void number() {
        while (isDigit(peek())) consume();

        if (peek() == '.' && isDigit(peekNext())) {
            consume();

            while (isDigit(peek())) consume();
        }

        newToken(TokenType.NUMBER, Double.parseDouble(input.substring(start, current)));
    }

    private void identifier() {
        while (isAlphaNumeric(peek())) consume();

        String text = input.substring(start, current);
        TokenType type = keywords.get(text);
        if (type == null) type = TokenType.ID;
        newToken(type);
    }

    private static final Map<String, TokenType> keywords;

    static {
        keywords = new HashMap<>();
        keywords.put("and",    TokenType.AND);
        keywords.put("class",  TokenType.CLASS);
        keywords.put("else",   TokenType.ELSE);
        keywords.put("false",  TokenType.FALSE);
        keywords.put("for",    TokenType.FOR);
        keywords.put("fn",     TokenType.FN);
        keywords.put("nil",    TokenType.NIL);
        keywords.put("or",     TokenType.OR);
        keywords.put("print",  TokenType.PRINT);
        keywords.put("println",TokenType.PRINTLN);
        keywords.put("return", TokenType.RETURN);
        keywords.put("super",  TokenType.SUPER);
        keywords.put("this",   TokenType.THIS);
        keywords.put("true",   TokenType.TRUE);
        keywords.put("while",  TokenType.WHILE);
        keywords.put("set",    TokenType.SET);
    }

    private boolean isWhitespace(char c){
        return c == ' ' || c == '\t' || c == '\r';
    }
}