package crypt.language.utils;

import crypt.language.CryptInterpreter;
import crypt.language.lexer.CryptLexer;
import crypt.language.lexer.token.Token;
import crypt.language.parser.AST.Statement;
import crypt.language.parser.CryptParser;
import crypt.language.parser.environments.Resolver;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static crypt.language.Crypt.hadError;

public class Debug {
    public static CryptLexer lexer;
    public static CryptParser parser;
    public static final CryptInterpreter interpreter = new CryptInterpreter();
    private static long start, end;

    public static void tokenTestDebug(String input, boolean isPath) throws IOException {
        if(isPath){
            start = System.nanoTime();

            byte[] bytes = Files.readAllBytes(Paths.get(input));
            lexer = new CryptLexer(new String(bytes, Charset.defaultCharset()));
            List<Token> tokens = lexer.lex();
            tokens.forEach(System.out::println);

            end = System.nanoTime();

            System.out.println("Lexing complete in : " + (double)((end - start) / 1000000000) + "s");
            return;
        }

        start = System.nanoTime();

        lexer = new CryptLexer(input);
        List<Token> tokens = lexer.lex();
        tokens.forEach(System.out::println);

        end = System.nanoTime();
        System.out.println("Lexing complete in : " + (double)((end - start) / 1000000000) + "s");
    }

    public static void parseTestDebug(String input, boolean isPath) throws IOException {
        if(isPath){
            start = System.nanoTime();

            byte[] bytes = Files.readAllBytes(Paths.get(input));
            lexer = new CryptLexer(new String(bytes, Charset.defaultCharset()));
            List<Token> tokens = lexer.lex();

            parser = new CryptParser(tokens);
            parser.parse();

            end = System.nanoTime();

            if(parser.parseError) System.out.println("Parsing Unsuccessful, there is an error!");
            else System.out.println("Parsed Successfully!");

            System.out.println("Parsing complete in : " + (double)((end - start) / 1000000000) + "s");

            return;
        }

        start = System.nanoTime();

        lexer = new CryptLexer(input);
        List<Token> tokens = lexer.lex();

        parser = new CryptParser(tokens);
        parser.parse();

        end = System.nanoTime();

        if(parser.parseError) System.out.println("Parsing Unsuccessful, there is an error!");
        else System.out.println("Parsed Successfully!");

        System.out.println("Parsing complete in : " + (double)((end - start) / 1000000000) + "s");
    }

    public static void interpreterTestDebug(String input, boolean isPath) throws IOException {
        if(isPath){
            start = System.nanoTime();

            byte[] bytes = Files.readAllBytes(Paths.get(input));
            lexer = new CryptLexer(new String(bytes, Charset.defaultCharset()));
            List<Token> tokens = lexer.lex();

            parser = new CryptParser(tokens);
            List<Statement> statements = parser.parse();

            // Stop if there was a syntax error.
            if(hadError) return;

            Resolver resolver = new Resolver(interpreter);
            resolver.resolve(statements);

            if (hadError) return;

            interpreter.interpret(statements);

            end = System.nanoTime();

            if(parser.parseError) System.out.println("Interpreting Unsuccessful, there is an error!");
            else System.out.println("Interpreted Successfully!");

            System.out.println("Program run in : " + (double)((end - start) / 1000000000) + "s");

            return;
        }

        start = System.nanoTime();

        lexer = new CryptLexer(input);
        List<Token> tokens = lexer.lex();

        parser = new CryptParser(tokens);
        List<Statement> statements = parser.parse();

        // Stop if there was a syntax error.
        if(hadError) return;

        Resolver resolver = new Resolver(interpreter);
        resolver.resolve(statements);

        if (hadError) return;

        interpreter.interpret(statements);

        end = System.nanoTime();

        if(parser.parseError) System.out.println("Interpreting Unsuccessful, there is an error!");
        else System.out.println("Interpreted Successfully!");

        System.out.println("Program run in : " + (double)((end - start) / 1000000000) + "s");
    }
}
