package CryptCompiler.IRBuilder.statement;

import CryptCompiler.IRBuilder.expression.ExpressionBuilder;
import gen.CryptParser;
import gen.CryptParserBaseVisitor;
import org.objectweb.asm.MethodVisitor;

public class StatementBuilder extends CryptParserBaseVisitor<Void>{
    private final MethodVisitor methodVisitor;
    private final ExpressionBuilder expressionBuilder;

    public StatementBuilder(MethodVisitor methodVisitor){
        this.methodVisitor = methodVisitor;
        expressionBuilder = new ExpressionBuilder(methodVisitor);
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

    @Override
    public Void visitValueExpr(CryptParser.ValueExprContext ctx){
        expressionBuilder.visitValueExpr(ctx);
        return null;
    }

    @Override
    public Void visitAdd(CryptParser.AddContext ctx){
        expressionBuilder.visitAdd(ctx);
        return null;
    }

    @Override
    public Void visitSubtract(CryptParser.SubtractContext ctx){
        expressionBuilder.visitSubtract(ctx);
        return null;
    }

    @Override
    public Void visitMultiply(CryptParser.MultiplyContext ctx){
        expressionBuilder.visitMultiply(ctx);
        return null;
    }

    @Override
    public Void visitDivide(CryptParser.DivideContext ctx){
        expressionBuilder.visitDivide(ctx);
        return null;
    }
}
