package CryptCompiler.IRBuilder.statement;

import CryptCompiler.IRBuilder.expression.ExpressionBuilder;
import CryptCompiler.node.interfaces.Expression;
import gen.CryptParser;
import gen.CryptParserBaseVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class PrintlnBuilder extends CryptParserBaseVisitor<Void> {
    private final MethodVisitor methodVisitor;
    private final ExpressionBuilder expressionBuilder;

    public PrintlnBuilder(MethodVisitor methodVisitor){
        this.methodVisitor = methodVisitor;
        expressionBuilder = new ExpressionBuilder(methodVisitor);
    }

    @Override
    public Void visitPrintlnStatement(CryptParser.PrintlnStatementContext ctx){
        Expression expression = ctx.expression().accept(expressionBuilder);
        buildPrintln(expression, methodVisitor);
        return null;
    }

    public void buildPrintln(Expression expression, MethodVisitor methodVisitor){
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        String descriptor;

        if (expression == null) {
            descriptor = "()V";
        } else {
            descriptor = "(Ljava/lang/String)V";
        }

        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", descriptor);
    }
}
