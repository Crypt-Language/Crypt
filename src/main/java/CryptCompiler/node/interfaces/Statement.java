package CryptCompiler.node.interfaces;

import CryptCompiler.IRBuilder.statement.StatementBuilder;

public interface Statement {
    Statement acceptStatementBuilder(StatementBuilder builder);
}
