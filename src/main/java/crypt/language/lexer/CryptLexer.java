package crypt.language.lexer;

import crypt.language.Crypt;
import crypt.language.lexer.token.Token;
import crypt.language.lexer.token.TokenType;
import crypt.language.parser.environments.type.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static crypt.language.lexer.token.TokenType.*;

public class CryptLexer {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private static final Map<String, TokenType> keywords = new HashMap<>();
    private static final Map<String, Types> types = new HashMap<>();

    private int start = 0;
    private int current = 0;
    private int line = 1;

    //indent tracker
    private int indentLevel;
    private List<Integer> indentStack = new ArrayList<>();
    private int finalIndex = indentStack.size() - 1;

    public CryptLexer(String source){
        this.source = source;
        indentStack.add(0);
    }

    public List<Token> lex() {
        while (!isAtEnd()) {
            // We are at the beginning of the next lexeme.
            start = current;
            tokenize();
        }

        tokens.add(new Token(EOF, "", null, line));
        return tokens;
    }

    private void tokenize() {
        char c = consume();
        switch (c) {
            case '(': newToken(L_PAREN); break;
            case ')': newToken(R_PAREN); break;
            case '{': newToken(L_BRACE); break;
            case '}': newToken(R_BRACE); break;
            case ',': newToken(COMMA); break;
            case '.': newToken(DOT); break;
            case '?': newToken(Q_MARK); break;
            case '-':
                if(hasMatchedExpected('>')) newToken(ARROW_RIGHT);
                else newToken(MINUS);
                break;
            case '+': newToken(PLUS); break;
            case ';': newToken(SEMICOLON); break;
            case '*': newToken(ASTERISK); break;
            case '=':
                if(hasMatchedExpected('>')) newToken(ARROW_RIGHT_BIG);
                else newToken(EQUALS);
                break;
            case '~': newToken(TILDE); break;
            case '!':
                if(hasMatchedExpected('=')) newToken(NOT_EQUAL);
                else Crypt.error(line, "'!' operator doesn't exist! Maybe you are looking for the keyword 'not'");
                break;

            case '<':
                newToken(hasMatchedExpected('=') ? LESS_OR_EQUAL : LESS);
                break;

            case '>':
                if(hasMatchedExpected('=')) newToken(GREATER_OR_EQUAL);
                else newToken(GREATER);
                break;

            case ':':
                newToken(hasMatchedExpected(':') ? DB_COLON : COLON);
                break;

            case '/':
                if (hasMatchedExpected('/'))
                    // A comment goes until the end of the line.
                    while (peek() != '\n' && !isAtEnd()) consume();
                else if(hasMatchedExpected('*')) blockComment();
                else newToken(SLASH);
                break;

            case '"': string(); break;

            /*
            case '\n' :
                line++;
                if(peek() == ' '){
                    while(peek() == ' '){
                        indentLevel++;
                    }
                } else if(peek() == '\t'){
                    while(peek() == '\t'){
                        indentLevel++;
                    }
                }

                indent(indentLevel);
                break;

             */
            case '\n' : line++; break;
            case ' ':
            case '\t':
            case '\r' :
                break;

            default:
                if (isDigit(c)) number();
                else if (isAlpha(c)) identifier();
                else Crypt.error(line, "Unexpected character.");
                break;
        }
    }
    /*
     * ===================================
     * KEYWORDS
     * ===================================
     */

    static {
        keywords.put("and",    AND);
        keywords.put("type",  TYPE);
        keywords.put("else",   ELSE);
        keywords.put("false",  FALSE);
        keywords.put("for",    FOR);
        keywords.put("fn",    FN);
        keywords.put("if",     IF);
        keywords.put("nil",    NIL);
        keywords.put("or",     OR);
        keywords.put("print",  PRINT);
        keywords.put("println",  PRINTLN);
        keywords.put("return", RETURN);
        keywords.put("super",  SUPER);
        keywords.put("this",   THIS);
        keywords.put("true",   TRUE);
        keywords.put("let",    LET);
        keywords.put("while",  WHILE);
        keywords.put("to", TO);
        keywords.put("input", INPUT);

        types.put("int", Types.INT);
        types.put("str", Types.STRING);
        types.put("float", Types.FLOAT);
        types.put("double", Types.DOUBLE);
    }

    /*
     * ===================================
     * HELPER FUNCTIONS
     * ===================================
     */

    private boolean isAtEnd() {
        return current >= source.length();
    }

    private char consume() {
        return source.charAt(current++);
    }

    private void newToken(TokenType type) {
        newToken(type, null);
    }

    private void newToken(TokenType type, Object literal) {
        String text = source.substring(start, current);
        tokens.add(new Token(type, text, literal, line));
    }

    private boolean hasMatchedExpected(char expected) {
        if (isAtEnd()) return false;
        if (source.charAt(current) != expected) return false;

        current++;
        return true;
    }

    private char peek() {
        if (isAtEnd()) return '\0';
        return source.charAt(current);
    }

    private void string() {
        while (peek() != '"' && !isAtEnd()) {
            if (peek() == '\n') Crypt.error(line, "No multi-line string support");
            consume();
        }

        if (isAtEnd()) {
            Crypt.error(line, "Unterminated string.");
            return;
        }

        // The closing ".
        consume();

        // Trim the surrounding quotes.
        String value = source.substring(start + 1, current - 1);
        newToken(STRING, value);
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private void number() {
        while (isDigit(peek())) consume();

        // Look for a fractional part.
        if (peek() == '.' && isDigit(peekNext())) {
            // Consume the "."
            consume();

            while (isDigit(peek())) consume();
        }

        newToken(NUMBER, Double.parseDouble(source.substring(start, current)));
    }

    private char peekNext() {
        if (current + 1 >= source.length()) return '\0';
        return source.charAt(current + 1);
    }

    private void identifier() {
        while (isAlphaNumeric(peek())) consume();
        String text = source.substring(start, current);
        TokenType type = keywords.get(text);
        if (type == null) {
            type = ID;
            newToken(type);
        } else newToken(type);
    }

    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                c == '_';
    }

    private boolean isAlphaNumeric(char c) {
        return isAlpha(c) || isDigit(c);
    }
    private void blockComment(){
        while (!isAtEnd()) {
            if(hasMatchedExpected('*')){
                if(hasMatchedExpected('/'))break;
            } else consume();
        }
    }

    /*
    private void indent(int indentLevel) {
        if (indentLevel > indentStack.get(finalIndex)) {
            newToken(INDENT, "Indent Level" + indentLevel);
            indentStack.add(indentLevel);
        } else if (indentLevel < indentStack.get(finalIndex)) {
            while(indentLevel < indentStack.get(finalIndex)) {
                newToken(DEDENT);
                indentStack.remove(finalIndex);

                if(indentStack.get(finalIndex).equals(0)) break;
            }
        }
    }
     */
}
