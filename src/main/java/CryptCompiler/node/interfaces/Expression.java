package CryptCompiler.node.interfaces;

import CryptUtilities.gen.CryptParser;

public interface Expression{
    Type getTypeOf(CryptParser.ExpressionContext expressionContext);
}
