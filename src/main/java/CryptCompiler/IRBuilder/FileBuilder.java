package CryptCompiler.IRBuilder;

import CryptCompiler.IRBuilder.statement.StatementBuilder;
import CryptCompiler.node.file.FileUnit;
import CryptUtilities.gen.CryptParser;
import CryptUtilities.gen.CryptParserBaseVisitor;
import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;

public class FileBuilder extends CryptParserBaseVisitor<FileUnit> {
    private final String fileName;
    private final ClassWriter classWriter;
    private MethodVisitor mv;

    public FileBuilder(String fileName){
        this.fileName = fileName;
        classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
    }

    @Override
    public FileUnit visitFileUnit(CryptParser.FileUnitContext ctx){
        StatementBuilder statementBuilder = new StatementBuilder(mv);

        List<CryptParser.StatementContext> statements = ctx.fileBody().statement();

        return new FileUnit(statements);
    }

    public ClassWriter generate(FileUnit fileUnit){
        String name = StringUtils.remove(fileName, ".crypt");
        classWriter.visit(52, Opcodes.ACC_PUBLIC, name, null, "java/lang/Object", null);

        //Main method will be auto generated now
        mv = classWriter.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mv.visitCode();

        initializeMethodVisitor(mv);

        StatementBuilder statementBuilder = new StatementBuilder(mv);

        List<CryptParser.StatementContext> statementList = fileUnit.getStatements();
        statementList.forEach(statement -> statement.accept(statementBuilder));

        return classWriter;
    }

    public byte[] getBytecode(FileUnit fileUnit){
        return generate(fileUnit).toByteArray();
    }

    public void initializeMethodVisitor(MethodVisitor mv){
        this.mv = mv;
    }

}
