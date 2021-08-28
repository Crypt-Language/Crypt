package crypt.language.lexer.token;

public enum TokenType {
    // Single-character tokens.
    L_PAREN, R_PAREN, L_BRACE, R_BRACE, TILDE, Q_MARK,
    COMMA, DOT, MINUS, PLUS, SEMICOLON, SLASH, ASTERISK,EQUALS,NOT_EQUAL,

    // One or two character tokens.

    COLON, DB_COLON,
    GREATER, GREATER_OR_EQUAL, ARROW_RIGHT, ARROW_RIGHT_BIG,
    LESS, LESS_OR_EQUAL,

    // Literals.
    ID, STRING, NUMBER,

    //Indentation
    INDENT, DEDENT,

    // Keywords.
    AND, TYPE, ELSE, FALSE, FN, FOR, IF, NIL, OR, NOT, TO,
    PRINT, PRINTLN, RETURN, SUPER, THIS, TRUE, LET, WHILE,
    INPUT,

    EOF
}
