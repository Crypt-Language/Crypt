package CryptCompiler.IRBuilder.statement;

import gen.CryptParser;
import gen.CryptParserBaseVisitor;
import org.objectweb.asm.MethodVisitor;

public class StatementBuilder extends CryptParserBaseVisitor<Void>{
    private final MethodVisitor methodVisitor;

    public StatementBuilder(MethodVisitor methodVisitor){
        this.methodVisitor = methodVisitor;
    }



    @Override
    public Void visitPrintlnStatement(CryptParser.PrintlnStatementContext ctx){
        new PrintlnBuilder(methodVisitor).visitPrintlnStatement(ctx);
        return null;
    }

    @Override
    public Void visitPrintStatement(CryptParser.PrintStatementContext ctx){
        new PrintBuilder(methodVisitor).visitPrintStatement(ctx);
        return null;
    }
}
