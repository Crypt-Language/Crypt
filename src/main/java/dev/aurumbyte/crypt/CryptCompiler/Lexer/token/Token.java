package dev.aurumbyte.crypt.CryptCompiler.Lexer.token;

public class Token {
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
