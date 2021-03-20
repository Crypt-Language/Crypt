package CryptCompiler.IRBuilder.expression;

import CryptCompiler.node.interfaces.Expression;
import CryptUtilities.gen.CryptParser;
import CryptUtilities.gen.CryptParserBaseVisitor;
import org.jetbrains.annotations.NotNull;

public class ExpressionBuilder extends CryptParserBaseVisitor<Expression>{

    @Override
    public Expression visitValueExpr(@NotNull CryptParser.ValueExprContext ctx) {
        ValueExpressionBuilder valueExpressionBuilder = new ValueExpressionBuilder();
        valueExpressionBuilder.visitValue(ctx.value());
        return null;
    }

}
