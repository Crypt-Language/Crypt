package CryptCompiler.IRBuilder.statement;

import CryptCompiler.node.interfaces.Expression;
import gen.CryptParser;
import gen.CryptParserBaseVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class PrintlnBuilder extends CryptParserBaseVisitor<Void> {
    private final MethodVisitor methodVisitor;

    public PrintlnBuilder(MethodVisitor methodVisitor){
        this.methodVisitor = methodVisitor;
    }

    @Override
    public Void visitPrintlnStatement(CryptParser.PrintlnStatementContext ctx){
        Expression expression = ctx.expression().accept(null /*Need ExpressionBuilder*/);
        buildPrintln(expression, methodVisitor);
        return null;
    }

    public void buildPrintln(Expression expression, MethodVisitor methodVisitor){
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        String descriptor;

        if (expression != null) {
            descriptor = "(Ljava/lang/String)V";
        } else {
            descriptor = "()V";
        }

        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", descriptor);
    }
}
