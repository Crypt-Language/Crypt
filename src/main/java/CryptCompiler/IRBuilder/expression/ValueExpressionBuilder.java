package CryptCompiler.IRBuilder.expression;

import CryptCompiler.node.interfaces.Expression;
import CryptCompiler.node.interfaces.Type;
import CryptUtilities.util.TypeResolver;
import gen.CryptParser;
import gen.CryptParserBaseVisitor;
import org.objectweb.asm.MethodVisitor;

public class ValueExpressionBuilder extends CryptParserBaseVisitor<Expression> {
    private final MethodVisitor methodVisitor;

    public ValueExpressionBuilder(MethodVisitor methodVisitor){
        this.methodVisitor = methodVisitor;
    }

    @Override
    public Expression visitValue(CryptParser.ValueContext ctx){
        String value = ctx.getText();
        Type type = TypeResolver.getFromValue(ctx);

        buildValue(type, value);
        return null;
    }

    public void buildValue(Type type, String value){
        Object transformedValue = TypeResolver.getValueFromString(value, type);
        methodVisitor.visitLdcInsn(transformedValue);
    }
}
