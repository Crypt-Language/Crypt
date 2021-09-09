package crypt.language.IRBuilder.generator.statement;

import crypt.language.IRBuilder.generator.ExpressionGenerator;
import crypt.language.parser.AST.Expression;
import crypt.language.parser.AST.Statement;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public record PrintlnStatementGenerator(ExpressionGenerator expressionGenerator, MethodVisitor methodVisitor) {
    public void generate(Statement.Println printStatement) {
        Expression expression = printStatement.expression;
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        //expression.visit(expressionGenerator);
        //Type type = expression.getType();
        //String descriptor = "(" + type.getDescriptor() + ")V";
        //methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", descriptor, false);
    }
}

