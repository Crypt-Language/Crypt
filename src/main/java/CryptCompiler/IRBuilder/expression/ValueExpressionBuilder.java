package CryptCompiler.IRBuilder.expression;

import CryptCompiler.node.interfaces.Type;
import CryptUtilities.gen.CryptParser;
import CryptUtilities.gen.CryptParserBaseVisitor;
import CryptUtilities.util.TypeResolver;

public class ValueExpressionBuilder extends CryptParserBaseVisitor<Void> {
    @Override
    public Void visitValue(CryptParser.ValueContext ctx){
        String value = ctx.getText();
        Type type = TypeResolver.getFromValue(ctx);

        //buildValue(type, value);
        return null;
    }
}
