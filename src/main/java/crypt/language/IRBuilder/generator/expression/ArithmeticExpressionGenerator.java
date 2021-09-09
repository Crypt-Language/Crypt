package crypt.language.IRBuilder.generator.expression;

import crypt.language.IRBuilder.generator.ExpressionGenerator;
import crypt.language.IRBuilder.type.DescriptorFactory;
import crypt.language.IRBuilder.type.Type;
import crypt.language.IRBuilder.type.TypeFactory;
import crypt.language.IRBuilder.type.Types;
import crypt.language.parser.AST.Expression;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.IOException;
import java.util.Objects;

import static crypt.language.lexer.token.TokenType.*;

public class ArithmeticExpressionGenerator {
    private final ExpressionGenerator expressionGenerator;
    private final MethodVisitor methodVisitor;

    public ArithmeticExpressionGenerator(ExpressionGenerator expressionGenerator, MethodVisitor methodVisitor) {
        this.expressionGenerator = expressionGenerator;
        this.methodVisitor = methodVisitor;
    }

    public void generate(Expression.Binary expression) throws IOException {
        if(Objects.equals(expression.operator.type, PLUS)) generateAddition(expression);
        if(Objects.equals(expression.operator.type, MINUS)) generateSubtraction(expression);
        if(Objects.equals(expression.operator.type, ASTERISK)) generateMultiplication(expression);
        if(Objects.equals(expression.operator.type, SLASH)) generateDivision(expression);
    }

    public void generateAddition(Expression.Binary expression) throws IOException {
        if (TypeFactory.getType(expression).equals(Types.STRING)) {
            generateStringAppend(expression);
            return;
        }
        evaluateArithmeticComponents(expression);
        Type type = TypeFactory.getType(expression);
        methodVisitor.visitInsn(type.getAddOpcode());
    }

    public void generateSubtraction(Expression.Binary expression) throws IOException {
        Type type = TypeFactory.getType(expression);
        evaluateArithmeticComponents(expression);
        methodVisitor.visitInsn(type.getSubtractOpcode());
    }

    public void generateMultiplication(Expression.Binary expression) throws IOException {
        evaluateArithmeticComponents(expression);
        Type type = TypeFactory.getType(expression);
        methodVisitor.visitInsn(type.getMultiplyOpcode());
    }

    public void generateDivision(Expression.Binary expression) throws IOException {
        evaluateArithmeticComponents(expression);
        Type type = TypeFactory.getType(expression);
        methodVisitor.visitInsn(type.getDivideOpcode());
    }

    private void evaluateArithmeticComponents(Expression.Binary expression) throws IOException {
        Expression leftExpression = expression.left;
        Expression rightExpression = expression.right;
        leftExpression.accept(expressionGenerator);
        rightExpression.accept(expressionGenerator);
    }

    private void generateStringAppend(Expression.Binary expression) throws IOException {
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder");
        methodVisitor.visitInsn(Opcodes.DUP);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V");
        Expression leftExpression = expression.left;
        leftExpression.accept(expressionGenerator);
        String leftExprDescriptor = DescriptorFactory.getDescriptor(TypeFactory.getType(leftExpression));
        String descriptor = "(" + leftExprDescriptor + ")Ljava/lang/StringBuilder;";
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", descriptor);
        Expression rightExpression = expression.right;
        rightExpression.accept(expressionGenerator);
        String rightExprDescriptor = DescriptorFactory.getDescriptor(TypeFactory.getType(rightExpression));
        descriptor = "(" + rightExprDescriptor + ")Ljava/lang/StringBuilder;";
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", descriptor);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
    }
}
