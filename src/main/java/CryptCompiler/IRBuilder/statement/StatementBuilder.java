package CryptCompiler.IRBuilder.statement;

import gen.CryptParser;
import gen.CryptParserBaseVisitor;
import org.objectweb.asm.MethodVisitor;

public class StatementBuilder extends CryptParserBaseVisitor<Void> {
    private final MethodVisitor methodVisitor;

    public StatementBuilder(MethodVisitor methodVisitor){
        this.methodVisitor = methodVisitor;
    }

    @Override
    public Void visitStatement(CryptParser.StatementContext ctx){
        if (ctx.getRuleContext() == ctx.printlnStatement()){
            PrintlnBuilder printlnBuilder = new PrintlnBuilder(methodVisitor);
            printlnBuilder.visitPrintlnStatement(ctx.printlnStatement());
        }
        return null;
    }
}
