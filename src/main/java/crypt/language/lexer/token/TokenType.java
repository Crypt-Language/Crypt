package crypt.language.lexer.token;

public enum TokenType {
    // Single-character tokens.
    L_PAREN, R_PAREN, L_BRACE, R_BRACE, TILDE,
    COMMA, DOT, MINUS, PLUS, SEMICOLON, SLASH, ASTERISK,EQUALS,NOT_EQUAL,

    // One or two character tokens.

    COLON, DB_COLON,
    GREATER, GREATER_OR_EQUAL, BLOCK_OP,
    LESS, LESS_OR_EQUAL,

    // Literals.
    ID, STRING, NUMBER,

    //Indentation
    INDENT, DEDENT,

    // Keywords.
    AND, TYPE, ELSE, FALSE, FN, FOR, IF, NIL, OR, NOT,
    PRINT, PRINTLN, RETURN, SUPER, THIS, TRUE, SET, WHILE,

    EOF
}
