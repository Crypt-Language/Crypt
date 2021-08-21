package crypt.language;

import crypt.language.error.RuntimeError;
import crypt.language.lexer.CryptLexer;
import crypt.language.lexer.token.Token;
import crypt.language.parser.AST.Statement;
import crypt.language.parser.CryptParser;
import crypt.language.parser.environments.Resolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Crypt {
    public static boolean hadError = false;
    public static final CryptInterpreter interpreter = new CryptInterpreter();

    public static void main(String[] args) throws IOException {
        //if (args.length > 1) {
        //    System.out.println("Usage: crypt [script]");
        //    System.exit(64);
        //} else if (args.length == 1) {
        //    runFile(args[0]);
        //} else {
        //    runPrompt();
        //}

        runCommandPrompts();
    }

    public static void runCommandPrompts() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        System.out.println("Crypt > Enter command (help for list of cammands)");

        for(;;) {
            String command = reader.readLine();
            String[] args = command.split(" ");

            switch (args[0]) {
                case "help":
                    System.out.println("List of commands:");
                    System.out.println("crypt <path to file>");
                    System.out.println("runPrompt");
                    System.out.println("exit");
                    break;

                case "crypt":
                    if (args[1] != null) runFile(args[1]);
                    else System.out.println("Command : crypt. Usage: \n crypt <path to file>");
                    break;

                case "exit":
                    System.exit(0);
                    break;

                case "runPrompt":
                    runPrompt();
                    break;

                default:
                    System.err.println("Invalid command input!");
                    break;
            }
        }

    }

    private static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes, Charset.defaultCharset()));

        if (hadError) System.exit(65);
        if (CryptInterpreter.hadRuntimeError) System.exit(70);
    }

    private static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        for (;;) {
            System.out.print("Crypt > ");
            String line = reader.readLine();
            if (line == null) break;
            run(line);
            hadError = false;
        }
    }

    private static void run(String source) {
        CryptLexer lexer = new CryptLexer(source);
        List<Token> tokens = lexer.lex();
        CryptParser parser = new CryptParser(tokens);
        List<Statement> statements = parser.parse();

        // Stop if there was a syntax error.
        if(hadError) return;

        //Resolver resolver = new Resolver(interpreter);
        //resolver.resolve(statements);

        //if (hadError) return;

        interpreter.interpret(statements);
    }

    public static void error(int line, String message) {
        report(line, message);
    }

    private static void report(int line, String message) {
        System.err.println("line : " + line + " Error => '" + "" + "' | " + message);
        hadError = true;
        return;
    }

    public static void runtimeError(RuntimeError error){
        error.printStackTrace();
    }
}
