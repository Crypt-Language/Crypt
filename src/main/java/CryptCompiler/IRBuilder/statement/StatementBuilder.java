package CryptCompiler.IRBuilder.statement;

import CryptCompiler.node.interfaces.Statement;
import gen.CryptParser;
import gen.CryptParserBaseVisitor;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.MethodVisitor;

public class StatementBuilder extends CryptParserBaseVisitor<Void> implements Statement {
    private final MethodVisitor methodVisitor;
    private CryptParser.StatementContext statementContext;

    public StatementBuilder(MethodVisitor methodVisitor){
        this.methodVisitor = methodVisitor;
    }

    @Override
    public Void visitStatement(@NotNull CryptParser.StatementContext ctx){
        statementContext = (CryptParser.StatementContext) ctx.getRuleContext();

        if (ctx.getRuleContext() == ctx.printlnStatement()){
            PrintlnBuilder printlnBuilder = new PrintlnBuilder(methodVisitor);
            printlnBuilder.visitPrintlnStatement(ctx.printlnStatement());
        }
        return null;
    }

    @Override
    public Statement acceptStatementBuilder(@NotNull StatementBuilder builder) {
        builder.visitStatement(statementContext);
        return null;
    }
}
