package CryptCompiler.IRBuilder.expression.arithmetic;

import CryptCompiler.IRBuilder.expression.ExpressionBuilder;
import CryptCompiler.node.interfaces.Expression;
import CryptUtilities.gen.CryptParser;
import CryptUtilities.gen.CryptParserBaseVisitor;
import org.jetbrains.annotations.NotNull;

public class ArithmeticExpressionBuilder extends CryptParserBaseVisitor<Void> {
    private final ExpressionBuilder expressionBuilder;

    public ArithmeticExpressionBuilder(ExpressionBuilder expressionBuilder){
        this.expressionBuilder = expressionBuilder;
    }

    @Override
    public Void visitAdd(@NotNull CryptParser.AddContext ctx) {
        CryptParser.ExpressionContext leftExpression = ctx.expression(0);
        CryptParser.ExpressionContext rightExpression = ctx.expression(1);

        Expression leftExpr = leftExpression.accept(expressionBuilder);
        Expression rightExpr = rightExpression.accept(expressionBuilder);

        //buildAddition(leftExpr, rightExpr);
        return null;
    }

    @Override
    public Void visitMultiply(@NotNull CryptParser.MultiplyContext ctx) {
        CryptParser.ExpressionContext leftExpression = ctx.expression(0);
        CryptParser.ExpressionContext rightExpression = ctx.expression(1);

        Expression leftExpr = leftExpression.accept(expressionBuilder);
        Expression rightExpr = rightExpression.accept(expressionBuilder);

        //buildMultiplication(leftExpr, rightExpr);
        return null;
    }

    @Override
    public Void visitSubtract(@NotNull CryptParser.SubtractContext ctx) {
        CryptParser.ExpressionContext leftExpression = ctx.expression(0);
        CryptParser.ExpressionContext rightExpression = ctx.expression(1);

        Expression leftExpr = leftExpression.accept(expressionBuilder);
        Expression rightExpr = rightExpression.accept(expressionBuilder);

        //buildSubtraction(leftExpr, rightExpr);
        return null;
    }

    @Override
    public Void visitDivide(@NotNull CryptParser.DivideContext ctx) {
        CryptParser.ExpressionContext leftExpression = ctx.expression(0);
        CryptParser.ExpressionContext rightExpression = ctx.expression(1);

        Expression leftExpr = leftExpression.accept(expressionBuilder);
        Expression rightExpr = rightExpression.accept(expressionBuilder);

        //buildDivision(leftExpr, rightExpr);
        return null;
    }
}
