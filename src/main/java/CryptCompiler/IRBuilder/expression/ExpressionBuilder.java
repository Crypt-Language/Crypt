package CryptCompiler.IRBuilder.expression;

import CryptCompiler.IRBuilder.statement.StatementBuilder;
import CryptCompiler.node.interfaces.Expression;
import CryptCompiler.node.interfaces.Statement;
import CryptCompiler.node.interfaces.Type;
import gen.CryptParser;
import gen.CryptParserBaseVisitor;
import org.jetbrains.annotations.NotNull;

public class ExpressionBuilder extends CryptParserBaseVisitor<Void> implements Expression {
    private CryptParser.ValueExprContext valueExprContext;

    @Override
    public Void visitValueExpr(@NotNull CryptParser.ValueExprContext ctx) {
        Expression valueExpression = (Expression) ctx.value();
        visitValue(ctx.value());
        return null;
    }

    @Override
    public Void visitValue(@NotNull CryptParser.ValueContext ctx){
        if(ctx.getRuleContext() == ctx.STRING_START()){
            return null;
        } else if (ctx.getRuleContext() == ctx.decimal()){
            return null;
            //TODO: Fix Nulls
        }
        return null;
    }

    @Override
    public Type getTypeOf() {
        return null;
    }

    @Override
    public void acceptExpressionBuilder(@NotNull ExpressionBuilder builder) {
        builder.visitValueExpr(valueExprContext);
    }

    @Override
    public Statement acceptStatementBuilder(@NotNull StatementBuilder builder) {
        builder.visitStatement(null /*TODO: Fix StatementBuilder Null later*/);
        return null;
    }
}
