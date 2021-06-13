package CryptCompiler.Lexer.token;

import CryptCompiler.Lexer.CryptLexer;

public class Token {

    // the type of token (as an int). Refer TokenType.java if confused
    public TokenType type;

    public String text;
    public int line;
    public Object literal;
    public String lexeme;

    public Token(TokenType type, String lexeme, Object literal, int line){
        this.type = type;
        this.literal = literal;
        this.line = line;
        this.lexeme = lexeme;
    }

    public String toString(){
        return "{ " + type + " | " + lexeme + " | " + line +  " }";
    }
}
