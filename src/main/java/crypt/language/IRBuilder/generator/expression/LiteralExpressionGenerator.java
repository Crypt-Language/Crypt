package crypt.language.IRBuilder.generator.expression;

import crypt.language.IRBuilder.type.DescriptorFactory;
import crypt.language.IRBuilder.type.Type;
import crypt.language.IRBuilder.type.TypeFactory;
import crypt.language.IRBuilder.type.TypeResolver;
import crypt.language.parser.AST.Expression;
import org.objectweb.asm.MethodVisitor;

public class LiteralExpressionGenerator {
    private final MethodVisitor methodVisitor;

    public LiteralExpressionGenerator(MethodVisitor methodVisitor){
        this.methodVisitor = methodVisitor;
    }

    public void generate(Expression.Literal expression){
        Type type = TypeFactory.getType(expression);
        String value = expression.value.toString();
        Object finalValue = TypeResolver.getValueFromString(value, type);
        methodVisitor.visitLdcInsn(finalValue);
    }
}
