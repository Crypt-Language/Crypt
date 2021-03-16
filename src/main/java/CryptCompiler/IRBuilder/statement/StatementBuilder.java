package CryptCompiler.IRBuilder.statement;

import CryptCompiler.node.interfaces.Statement;
import CryptUtilities.gen.CryptParser;
import CryptUtilities.gen.CryptParserBaseVisitor;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.MethodVisitor;

public class StatementBuilder extends CryptParserBaseVisitor<Statement> implements Statement {
    private final MethodVisitor methodVisitor;
    private CryptParser.StatementContext statementContext;

    public StatementBuilder(MethodVisitor methodVisitor){
        this.methodVisitor = methodVisitor;
    }

    @Override
    public Statement visitStatement(@NotNull CryptParser.StatementContext ctx){
        statementContext = (CryptParser.StatementContext) ctx.getRuleContext();

        if (!ctx.isEmpty() && ctx.getRuleContext() == ctx.printlnStatement()){
            PrintlnBuilder printlnBuilder = new PrintlnBuilder(methodVisitor);
            printlnBuilder.visitPrintlnStatement(ctx.printlnStatement());
        } else if (!ctx.isEmpty() && ctx.getRuleContext() == ctx.printStatement()){
            PrintBuilder printBuilder = new PrintBuilder(methodVisitor);
            printBuilder.visitPrintStatement(ctx.printStatement());
        }
        return null;
    }

    @Override
    public Statement acceptStatementBuilder(@NotNull StatementBuilder builder) {
        builder.visitStatement(statementContext);
        return null;
    }
}
