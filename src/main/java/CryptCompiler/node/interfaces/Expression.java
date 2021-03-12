package CryptCompiler.node.interfaces;

public interface Expression extends Statement {
    Type getTypeOf();
    void acceptExpressionGenerator();

    @Override
    void acceptStatementGenerator();
}
