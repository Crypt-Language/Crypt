package crypt.language;

import crypt.language.IRBuilder.IRBuilder;
import crypt.language.error.RuntimeError;
import crypt.language.lexer.CryptLexer;
import crypt.language.lexer.token.Token;
import crypt.language.parser.AST.Statement;
import crypt.language.parser.CryptParser;
import crypt.language.parser.environments.Resolver;
import crypt.language.utils.Debug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class Crypt {
    public static boolean hadError = false;
    public static final CryptInterpreter interpreter = new CryptInterpreter();
    public static final IRBuilder builder = new IRBuilder();

    public static void main(String[] args) throws IOException {
        runCommandPrompts();
    }

    public static void runCommandPrompts() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        System.out.println("Crypt > Enter command (commands for list of commands)");

        for(;;) {
            String command = reader.readLine();
            String[] args = command.split(" ");

            switch (args[0]) {
                case "commands":
                    printCommandList();
                    break;

                case "help":
                    helpCommands(args[1]);
                    break;

                case "crypt":
                    if (!args[1].isEmpty()) runFile(args[1]);
                    break;

                case "exit":
                    System.exit(0);
                    break;

                case "runPrompt":
                    runPrompt();
                    break;

                case "cryptc":
                    if (args[1] != null) buildFile(args[1]);
                    else System.out.println("Command : cryptc. Usage: \n cryptc <path to file>");
                    break;

                case "debug":
                    if(args[1] == null) System.out.println("Error! Parameters not given or are null!");
                    else {
                        debug(args[1], args[2], args[3]);
                    }
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

    private static void buildFile(String path) throws IOException {
        if(!path.endsWith(".crypt")) System.err.println("Wrong file extension! Crypt files end with '.crypt'");

        System.out.println("Parsing '" + path + "'...");
        builder.parse(path);

        System.out.println("Parsed Successfully! Generating Bytecode...");
        byte[] bytecode = builder.generateBytecode();
        builder.saveBytecodeToClassFile(bytecode);

        System.out.println("File compiled successfully! To run the file, run 'java "+ builder.classFile.getName().replace(".class", "") +"' in the terminal");

        if (hadError) System.exit(65);
        if (CryptInterpreter.hadRuntimeError) System.exit(70);
    }

    private static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        for (;;) {
            System.out.print("Crypt > ");
            String line = reader.readLine();
            if (line == null) System.out.println("Invalid Input! If you wish to exit the REPL, type \"exitPrompt\"");
            if (Objects.equals(line, "exitPrompt")) break;
            run(line);
            hadError = false;
        }
    }

    private static void run(String source) throws IOException {
        CryptLexer lexer = new CryptLexer(source);
        List<Token> tokens = lexer.lex();

        CryptParser parser = new CryptParser(tokens);
        List<Statement> statements = parser.parse();

        // Stop if there was a syntax error.
        if(hadError) return;

        Resolver resolver = new Resolver(interpreter);
        resolver.resolve(statements);

        if (hadError) return;

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

    public static void printCommandList(){
        System.out.println(" ========================================");
        System.out.println(" ========== Crypt Command Table =========");
        System.out.println(" ========================================\n");
        System.out.println(" <<<<< List of commands: (For command help, type 'help <command name>') >>>>>");
        System.out.println(" -> help <command name>");
        System.out.println(" -> crypt <path to file>");
        System.out.println(" -> cryptc <path to file>");
        System.out.println(" -> runPrompt");
        System.out.println(" -> exit");
        System.out.println(" -> debug <mode> <statement or filePath> <isPath>");
    }

    private static void helpCommands(String command){
        switch (command){
            case "help":
                System.out.println("\n Usage : help (or) help <command name>");
                System.out.println("help command, does what it's supposed to do.");
                break;

            case "crypt":
                System.out.println("\n Usage : crypt <path to file>");
                System.out.println("Runs the file on the Crypt Interpreter");
                break;

            case "exit":
                System.out.println("\n Usage : exit");
                System.out.println("Exits the command prompt");
                break;

            case "runPrompt":
                System.out.println("\n Usage : runPrompt");
                System.out.println("Runs the Crypt REPL");
                break;

            case "cryptc":
                System.out.println("\n Usage : cryptc <path to file>");
                System.out.println("Compiles the Crypt file into JVM bytecode to be executed\n Status : Experimental");
                break;

            case "commands":
                System.out.println("\n Usage : commands");
                System.out.println("Lists all the commands");
                break;

            case "debug":
                System.out.println("\n Usage : debug <mode> <statement or filePath> <isPath>");
                System.out.println("Helpful for debugging the lexer, parser or interpreter on the spot, \nThe third argument \"isPath\" is used to specify whether the input is a file path or not. \nWhen debugging statements directly, make sure it is in one line if multiple statements are present, \nand also do not use whitespace in the statement.");
                break;

            default:
                printCommandList();
                break;
        }
    }

    public static void debug(String mode, String input, String isPath) throws IOException {
        switch (mode) {
            case "lexer" -> Debug.tokenTestDebug(input, Objects.equals(isPath, "true"));
            case "parser" -> Debug.parseTestDebug(input, Objects.equals(isPath, "true"));
            case "interpreter" -> Debug.interpreterTestDebug(input, Objects.equals(isPath, "true"));
            default -> System.out.println("There are only lexer, parser and interpreter debug modes!");
        }
    }

    public static void runtimeError(RuntimeError error){
        error.printStackTrace();
    }
}
