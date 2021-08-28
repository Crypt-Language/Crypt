package crypt.language.IRBuilder.generator;

import crypt.language.parser.AST.Expression;

public class ExpressionGenerator implements Expression.Visitor{
    @Override
    public Object visit(Expression expression) {
        return null;
    }

    @Override
    public Object visitBinaryExpression(Expression.Binary expression) {
        return null;
    }

    @Override
    public Object visitGroupingExpression(Expression.Grouping expression) {
        return null;
    }

    @Override
    public Object visitLiteralExpression(Expression.Literal expression) {
        return null;
    }

    @Override
    public Object visitUnaryExpression(Expression.Unary expression) {
        return null;
    }

    @Override
    public Object visitVariableReference(Expression.Variable expression) {
        return null;
    }

    @Override
    public Object visitAssignment(Expression.Assignment expression) {
        return null;
    }

    @Override
    public Object visitLogicalExpression(Expression.Logical expression) {
        return null;
    }

    @Override
    public Object visitCallExpression(Expression.Call expression) {
        return null;
    }

    @Override
    public Object visitGetExpression(Expression.Get expression) {
        return null;
    }

    @Override
    public Object visitSetExpression(Expression.Set expression) {
        return null;
    }

    @Override
    public Object visitThisExpression(Expression.This expression) {
        return null;
    }

    @Override
    public Object visitSuperExpression(Expression.Super expression) {
        return null;
    }
}
