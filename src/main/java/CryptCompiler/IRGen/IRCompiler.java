package CryptCompiler.IRGen;

import CryptCompiler.utils.Expression;
import CryptCompiler.utils.Statement;

public class IRCompiler implements Expression.Visitor<Object>, Statement.Visitor<Void> {
    @Override
    public Object visitBinaryExpression() {
        return null;
    }

    @Override
    public Object visitLiteralExpression() {
        return null;
    }

    @Override
    public Object visitUnaryExpression() {
        return null;
    }

    @Override
    public Object visitGrouping() {
        return null;
    }

    @Override
    public Object visitVariableExpression() {
        return null;
    }

    @Override
    public Object visitLogicalExpression() {
        return null;
    }

    @Override
    public Object visit(Expression expression) {
        return null;
    }

    @Override
    public Void visitPrintStatement() {
        return null;
    }

    @Override
    public Void visitPrintlnStatement() {
        return null;
    }

    @Override
    public Void visitExpressionStatement() {
        return null;
    }

    @Override
    public Void visitVariableDeclarationStatement() {
        return null;
    }

    @Override
    public Void visitBlockStatement() {
        return null;
    }

    @Override
    public Void visitIfStatement() {
        return null;
    }

    @Override
    public Void visitWhileStatement() {
        return null;
    }

    @Override
    public Void visit(Statement statement) {
        return null;
    }
}
