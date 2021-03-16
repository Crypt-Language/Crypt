package CryptCompiler.IRBuilder.expression;

import CryptCompiler.node.interfaces.Expression;
import CryptUtilities.gen.CryptParser;
import CryptUtilities.gen.CryptParserBaseVisitor;
import org.jetbrains.annotations.NotNull;

public class ExpressionBuilder extends CryptParserBaseVisitor<Expression>{
    private CryptParser.ValueExprContext valueExprContext;

    @Override
    public Expression visitValueExpr(@NotNull CryptParser.ValueExprContext ctx) {
        visitValue(ctx.value());
        return null;
    }

    @Override
    public Expression visitValue(@NotNull CryptParser.ValueContext ctx){
        if(ctx.getRuleContext() == ctx.STRING_START()){
            return null;
        } else if (ctx.getRuleContext() == ctx.decimal()){
            return null;
            //TODO: Fix Nulls
        }
        return null;
    }

}
