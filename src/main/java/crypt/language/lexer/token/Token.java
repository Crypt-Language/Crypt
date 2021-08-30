package crypt.language.lexer.token;

import crypt.language.parser.environments.type.Types;

public class Token {
    public final TokenType type;
    public final Types varType;
    public final String lexeme;
    public final Object literal;
    public final int line;

    public Token(TokenType type, String lexeme, Object literal, int line) {
        this.type = type;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
        this.varType = null;
    }

    public Token(Types type, String lexeme, Object literal, int line) {
        this.varType = type;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
        this.type = null;
    }

    public String toString() {
        return "[" + type + " | " + lexeme + " | " + literal + "]";
    }
}
