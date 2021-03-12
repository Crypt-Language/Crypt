package CryptCompiler.node.interfaces;

public interface Reference extends Expression{
    String getName();

    @Override
    void acceptExpressionGenerator(/*ExpressionBuilder builder*/);

    @Override
    void acceptStatementGenerator(/*StatementBuilder builder*/);
}
