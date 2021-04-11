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
    public Expression visitValueExpr(CryptParser.ValueExprContext ctx){
        String value = ctx.value().getText();
        Type type = TypeResolver.getFromValue(ctx.value());
        buildValue(value, type);
        return null;
    }

    public void buildValue(String value, Type type){
        Object transformedValue = TypeResolver.getValueFromString(value, type);
        methodVisitor.visitLdcInsn(transformedValue);
    }
}
