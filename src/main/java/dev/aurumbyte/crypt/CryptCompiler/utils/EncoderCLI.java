package dev.aurumbyte.crypt.CryptCompiler.utils;

import dev.aurumbyte.crypt.CryptCompiler.IRGen.IRCompiler;
import dev.aurumbyte.crypt.CryptCompiler.Lexer.CryptLexer;
import dev.aurumbyte.crypt.CryptCompiler.Lexer.token.Token;
import dev.aurumbyte.crypt.CryptCompiler.Parser.CryptParser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EncoderCLI {
    public static boolean hadError = false;

    public void main(String[] args){
        try {
            runCLI(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runCLI(String[] args) throws Exception {
        if(args.length == 0){
            help();
        }
        String command = args[0];
        switch (command){
            case "cryptc" : {
                runFile(args[1]);
            }
            case "crypt"  : break;
            default : throw new IOException();
        }
    }

    public void help(){

    }

    public static void runFile(String path) throws Exception {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes, Charset.defaultCharset()));
    }

    private static void run(String source) throws Exception {
        if(hadError){ return; }

        CryptLexer lexer = new CryptLexer(source);
        List<Token> tokens = lexer.lex();
        CryptParser parser = new CryptParser(tokens);
        List<Statement> statements = parser.parse();
        IRCompiler irCompiler = new IRCompiler(statements);
    }

    public static void error(int line, String message) {
        report(line, message);
    }

    private static void report(int line, /*String where,*/ String message) {
        System.err.println("line " + line + " => Error : "/* + where + " : "*/ + message);
        hadError = true;
    }
}