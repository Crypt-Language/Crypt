package CryptCompiler.IRBuilder.expression;

import CryptCompiler.IRBuilder.expression.arithmetic.ArithmeticExpressionBuilder;
import CryptCompiler.node.interfaces.Expression;
import gen.CryptParser;
import gen.CryptParserBaseVisitor;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.MethodVisitor;

public class ExpressionBuilder extends CryptParserBaseVisitor<Expression>{
    private final ArithmeticExpressionBuilder arithmeticExpressionBuilder;
    private final ValueExpressionBuilder valueExpressionBuilder;

    public ExpressionBuilder(MethodVisitor methodVisitor){
        arithmeticExpressionBuilder = new ArithmeticExpressionBuilder(this, methodVisitor);
        valueExpressionBuilder = new ValueExpressionBuilder(methodVisitor);
    }

    @Override
    public Expression visitValueExpr(@NotNull CryptParser.ValueExprContext ctx) {
        valueExpressionBuilder.visitValue(ctx.value());
        return null;
    }

    @Override
    public Expression visitAdd(@NotNull CryptParser.AddContext ctx){
        arithmeticExpressionBuilder.visitAdd(ctx);
        return null;
    }

    @Override
    public Expression visitMultiply(@NotNull CryptParser.MultiplyContext ctx){
        arithmeticExpressionBuilder.visitMultiply(ctx);
        return null;
    }

    @Override
    public Expression visitSubtract(@NotNull CryptParser.SubtractContext ctx){
        arithmeticExpressionBuilder.visitSubtract(ctx);
        return null;
    }

    @Override
    public Expression visitDivide(@NotNull CryptParser.DivideContext ctx){
        arithmeticExpressionBuilder.visitDivide(ctx);
        return null;
    }

}
