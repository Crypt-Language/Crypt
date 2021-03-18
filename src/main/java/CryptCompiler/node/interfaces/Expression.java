package CryptCompiler.node.interfaces;

import CryptCompiler.IRBuilder.expression.ExpressionBuilder;
import CryptCompiler.IRBuilder.statement.StatementBuilder;

public interface Expression extends Statement {
    Type getTypeOf();
    void acceptExpressionBuilder(ExpressionBuilder builder);

    @Override
    Statement acceptStatementBuilder(StatementBuilder builder);
}
