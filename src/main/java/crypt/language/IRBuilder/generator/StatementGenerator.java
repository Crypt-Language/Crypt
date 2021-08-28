package crypt.language.IRBuilder.generator;

import crypt.language.parser.AST.Statement;
import org.objectweb.asm.MethodVisitor;

import java.io.IOException;

public class StatementGenerator implements Statement.Visitor<Void>{
    private final MethodVisitor methodVisitor;

    public StatementGenerator(MethodVisitor methodVisitor){
        this.methodVisitor = methodVisitor;
    }

    ExpressionGenerator expressionGenerator = new ExpressionGenerator();

    @Override
    public Void visit(Statement statement) {
        return null;
    }

    @Override
    public Void visitPrintStatement(Statement.Print printStatement) {
        return null;
    }

    @Override
    public Void visitPrintlnStatement(Statement.Println printlnStatement) {
        return null;
    }

    @Override
    public Void visitExpressionStatement(Statement.ExpressionStatement expressionStatement) {
        return null;
    }

    @Override
    public Void visitVariableDeclaration(Statement.Variable statement) {
        return null;
    }

    @Override
    public Void visitBlockStatement(Statement.Block statement) {
        return null;
    }

    @Override
    public Void visitIfStatement(Statement.If statement) {
        return null;
    }

    @Override
    public Void visitWhileStatement(Statement.While statement) {
        return null;
    }

    @Override
    public Void visitFunctionDeclaration(Statement.Function statement) {
        return null;
    }

    @Override
    public Void visitReturnStatement(Statement.Return statement) {
        return null;
    }

    @Override
    public Void visitClassDeclaration(Statement.Class statement) {
        return null;
    }

    @Override
    public Void visitInputStatement(Statement.Input statement) throws IOException {
        return null;
    }
}
