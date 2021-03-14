package CryptCompiler.node.interfaces;

import CryptCompiler.IRBuilder.expression.ExpressionBuilder;
import CryptCompiler.IRBuilder.statement.StatementBuilder;

public interface Reference extends Expression{
    String getName();

    @Override
    void acceptExpressionBuilder(ExpressionBuilder builder);

    @Override
    Statement acceptStatementBuilder(StatementBuilder builder);
}
