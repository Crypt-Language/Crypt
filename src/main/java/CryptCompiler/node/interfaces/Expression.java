package CryptCompiler.node.interfaces;

import gen.CryptParser;

public interface Expression{
    Type getTypeOf(CryptParser.ExpressionContext expressionContext);
}
