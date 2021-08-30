package crypt.language.IRBuilder;

import crypt.language.IRBuilder.generator.StatementGenerator;
import crypt.language.lexer.CryptLexer;
import crypt.language.lexer.token.Token;
import crypt.language.parser.AST.Statement;
import crypt.language.parser.CryptParser;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IRBuilder implements Opcodes{
    private List<Statement> statements;
    private File file;
    public File classFile;
    private final ClassWriter classWriter = new ClassWriter(0);

    public void parse(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        CryptLexer lexer = new CryptLexer(new String(bytes, Charset.defaultCharset()));
        List<Token> tokens = lexer.lex();
        CryptParser parser = new CryptParser(tokens);
        statements = parser.parse();

        file = new File(path);
    }

    public byte[] generateBytecode(){
        classWriter.visit(52, ACC_PUBLIC + ACC_SUPER, file.getName().replace(".crypt", ""), null, "java/lang/Object", null);
        MethodVisitor methodVisitor = classWriter.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);

        /*
        * ============================================================
        * actual bytecode generation
        * ============================================================
        */
        StatementGenerator statementGenerator = new StatementGenerator(methodVisitor);
        statementGenerator.generate(statements);

        //methodVisitor.visitInsn(RETURN);
        methodVisitor.visitMaxs(100, 0);
        methodVisitor.visitEnd();


        classWriter.visitEnd();
        return classWriter.toByteArray();
    }

    public void saveBytecodeToClassFile(byte[] bytecode) throws IOException {
        classFile = new File(file.getName().replace(".crypt", ".class"));
        OutputStream outputStream = new FileOutputStream(classFile);
        outputStream.write(bytecode);
        outputStream.close();
    }
}
