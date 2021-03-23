package CryptCompiler.IRBuilder.statement;

import CryptCompiler.IRBuilder.expression.ExpressionBuilder;
import CryptCompiler.node.interfaces.Expression;
import CryptUtilities.gen.CryptParser;
import CryptUtilities.gen.CryptParserBaseVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class PrintBuilder extends CryptParserBaseVisitor<Void> {
    private final MethodVisitor methodVisitor;
    private final ExpressionBuilder expressionBuilder;

    public PrintBuilder(MethodVisitor methodVisitor){
        this.methodVisitor = methodVisitor;
        expressionBuilder = new ExpressionBuilder(methodVisitor);
    }

    @Override
    public Void visitPrintStatement(CryptParser.PrintStatementContext ctx){
        Expression expression = ctx.expression().accept(expressionBuilder);
        buildPrint(expression, methodVisitor);
        return null;
    }

    public void buildPrint(Expression expression, MethodVisitor methodVisitor){
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        String descriptor;

        if (expression != null) {
            descriptor = "(Ljava/lang/String)V";
        } else {
            descriptor = "()V";
        }

        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", descriptor);
    }
}
