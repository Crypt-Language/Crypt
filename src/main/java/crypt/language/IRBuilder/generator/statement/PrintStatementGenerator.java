package crypt.language.IRBuilder.generator.statement;

import crypt.language.IRBuilder.generator.ExpressionGenerator;
import crypt.language.IRBuilder.type.DescriptorFactory;
import crypt.language.IRBuilder.type.Type;
import crypt.language.IRBuilder.type.TypeFactory;
import crypt.language.parser.AST.Expression;
import crypt.language.parser.AST.Statement;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public record PrintStatementGenerator(ExpressionGenerator expressionGenerator, MethodVisitor methodVisitor) {

    public void generate(Statement.Print printStatement) {
        Expression expression = printStatement.expression;
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        expressionGenerator.generate(expression);
        Type type = TypeFactory.getType(expression);
        String descriptor = "(" + DescriptorFactory.getDescriptor(type) + ")V";
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", descriptor, false);
    }
}
