package CryptCompiler.IRBuilder.expression.arithmetic;

import CryptCompiler.IRBuilder.expression.ExpressionBuilder;
import CryptCompiler.IRBuilder.types.BuiltInTypes;
import CryptCompiler.node.interfaces.Type;
import CryptUtilities.util.TypeResolver;
import gen.CryptParser;
import gen.CryptParserBaseVisitor;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ArithmeticExpressionBuilder extends CryptParserBaseVisitor<Void>{
    private final ExpressionBuilder expressionBuilder;
    private final MethodVisitor methodVisitor;

    public ArithmeticExpressionBuilder(ExpressionBuilder expressionBuilder, MethodVisitor methodVisitor){
        this.expressionBuilder = expressionBuilder;
        this.methodVisitor = methodVisitor;
    }

    @Override
    public Void visitAdd(@NotNull CryptParser.AddContext ctx) {
        CryptParser.ExpressionContext leftExpression = ctx.expression(0);
        CryptParser.ExpressionContext rightExpression = ctx.expression(1);

        leftExpression.accept(expressionBuilder);
        rightExpression.accept(expressionBuilder);

        buildAddition(leftExpression, rightExpression);
        return null;
    }

    @Override
    public Void visitMultiply(@NotNull CryptParser.MultiplyContext ctx) {
        CryptParser.ExpressionContext leftExpression = ctx.expression(0);
        CryptParser.ExpressionContext rightExpression = ctx.expression(1);

        leftExpression.accept(expressionBuilder);
        rightExpression.accept(expressionBuilder);

        buildMultiplication(leftExpression, rightExpression);
        return null;
    }

    @Override
    public Void visitSubtract(@NotNull CryptParser.SubtractContext ctx) {
        CryptParser.ExpressionContext leftExpression = ctx.expression(0);
        CryptParser.ExpressionContext rightExpression = ctx.expression(1);

        leftExpression.accept(expressionBuilder);
        rightExpression.accept(expressionBuilder);

        buildSubtraction(leftExpression, rightExpression);
        return null;
    }

    @Override
    public Void visitDivide(@NotNull CryptParser.DivideContext ctx) {
        CryptParser.ExpressionContext leftExpression = ctx.expression(0);
        CryptParser.ExpressionContext rightExpression = ctx.expression(1);

        leftExpression.accept(expressionBuilder);
        rightExpression.accept(expressionBuilder);

        buildDivision(leftExpression, rightExpression);
        return null;
    }

    public void buildAddition(CryptParser.ExpressionContext leftExpr, CryptParser.ExpressionContext rightExpr){
        if (getTypeOf(leftExpr).equals(BuiltInTypes.STRING) && getTypeOf(rightExpr).equals(BuiltInTypes.STRING)) {
            generateStringAppend(leftExpr, rightExpr);
        }

        if(getTypeOf(leftExpr) == getTypeOf(rightExpr)) {
            Type type = getTypeOf(leftExpr);
            methodVisitor.visitInsn(type.getAddOpcode());
        } else {
            throw new ArithmeticException("Cross type addition not yet supported");
        }
    }

    public void buildSubtraction(CryptParser.ExpressionContext leftExpr, CryptParser.ExpressionContext rightExpr){
        if(getTypeOf(leftExpr) == getTypeOf(rightExpr)) {
            Type type = getTypeOf(leftExpr);
            methodVisitor.visitInsn(type.getSubtractOpcode());
        } else {
            throw new ArithmeticException("Cross type subtraction not yet supported");
        }
    }

    public void buildMultiplication(CryptParser.ExpressionContext leftExpr, CryptParser.ExpressionContext rightExpr){
        if(getTypeOf(leftExpr) == getTypeOf(rightExpr)) {
            Type type = getTypeOf(leftExpr);
            methodVisitor.visitInsn(type.getMultiplyOpcode());
        } else {
            throw new ArithmeticException("Cross type multiplication not yet supported");
        }
    }

    public void buildDivision(CryptParser.ExpressionContext leftExpr, CryptParser.ExpressionContext rightExpr){
        if(getTypeOf(leftExpr) == getTypeOf(rightExpr)) {
            Type type = getTypeOf(leftExpr);
            methodVisitor.visitInsn(type.getDivideOpcode());
        } else {
            throw new ArithmeticException("Cross type division not yet supported");
        }
    }

    private void generateStringAppend(CryptParser.ExpressionContext leftExpr, CryptParser.ExpressionContext rightExpr) {
        methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder");
        methodVisitor.visitInsn(Opcodes.DUP);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V");
        String leftExprDescriptor = getTypeOf(leftExpr).getDescriptor();
        String descriptor = "(" + leftExprDescriptor + ")Ljava/lang/StringBuilder;";
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", descriptor);
        String rightExprDescriptor = getTypeOf(rightExpr).getDescriptor();
        descriptor = "(" + rightExprDescriptor + ")Ljava/lang/StringBuilder;";
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", descriptor);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
    }

    public Type getTypeOf(CryptParser.ExpressionContext expressionContext){
        return TypeResolver.getFromExpression(expressionContext);
    }
}