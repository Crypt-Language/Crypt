package crypt.language.utils;

import crypt.language.lexer.CryptLexer;
import crypt.language.lexer.token.Token;
import crypt.language.parser.CryptParser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Debug {
    public static CryptLexer lexer;
    public static CryptParser parser;

    public static void tokenTestDebug(String input, boolean isPath) throws IOException {
        if(isPath){
            byte[] bytes = Files.readAllBytes(Paths.get(input));
            lexer = new CryptLexer(new String(bytes, Charset.defaultCharset()));
            List<Token> tokens = lexer.lex();
            tokens.forEach(System.out::println);
            return;
        }

        lexer = new CryptLexer(input);
        List<Token> tokens = lexer.lex();
        tokens.forEach(System.out::println);
    }

    public static void parseTestDebug(String input, boolean isPath) throws IOException {
        if(isPath){
            byte[] bytes = Files.readAllBytes(Paths.get(input));
            lexer = new CryptLexer(new String(bytes, Charset.defaultCharset()));
            List<Token> tokens = lexer.lex();

            parser = new CryptParser(tokens);
            parser.parse();

            if(parser.parseError) System.out.println("Parsing Unsuccessful, there is an error!");
            else System.out.println("Parsed Successfully!");

            return;
        }

        lexer = new CryptLexer(input);
        List<Token> tokens = lexer.lex();

        parser = new CryptParser(tokens);
        parser.parse();

        if(parser.parseError) System.out.println("Parsing Unsuccessful, there is an error!");
        else System.out.println("Parsed Successfully!");
    }
}
