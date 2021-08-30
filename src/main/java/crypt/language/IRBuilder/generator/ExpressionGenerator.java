package crypt.language.IRBuilder.generator;

import crypt.language.parser.AST.Expression;
import crypt.language.parser.AST.Statement;

import java.util.List;

public class ExpressionGenerator implements Expression.Visitor<Void>{
    public void generate(Expression expression){ visit(expression); }

    @Override
    public Void visit(Expression expression) {
        if(expression instanceof Expression.Binary) return visitBinaryExpression((Expression.Binary)expression);
        if(expression instanceof Expression.Unary) return visitUnaryExpression((Expression.Unary)expression);
        if(expression instanceof Expression.Grouping) return visitGroupingExpression((Expression.Grouping) expression);
        if(expression instanceof Expression.Literal) return visitLiteralExpression((Expression.Literal) expression);
        if(expression instanceof Expression.Variable) return visitVariableReference((Expression.Variable) expression);
        if(expression instanceof Expression.Assignment) return visitAssignment((Expression.Assignment) expression);
        if(expression instanceof Expression.Logical) return visitLogicalExpression((Expression.Logical) expression);
        if(expression instanceof Expression.Call) return visitCallExpression((Expression.Call) expression);
        if(expression instanceof Expression.Get) return visitGetExpression((Expression.Get) expression);
        if(expression instanceof Expression.Set) return visitSetExpression((Expression.Set) expression);
        if(expression instanceof Expression.This) return visitThisExpression((Expression.This) expression);
        if(expression instanceof Expression.Super) return visitSuperExpression((Expression.Super) expression);
        throw new Error("Expression not found");
    }

    @Override
    public Void visitBinaryExpression(Expression.Binary expression) {
        return null;
    }

    @Override
    public Void visitGroupingExpression(Expression.Grouping expression) {
        return null;
    }

    @Override
    public Void visitLiteralExpression(Expression.Literal expression) {
        return null;
    }

    @Override
    public Void visitUnaryExpression(Expression.Unary expression) {
        return null;
    }

    @Override
    public Void visitVariableReference(Expression.Variable expression) {
        return null;
    }

    @Override
    public Void visitAssignment(Expression.Assignment expression) {
        return null;
    }

    @Override
    public Void visitLogicalExpression(Expression.Logical expression) {
        return null;
    }

    @Override
    public Void visitCallExpression(Expression.Call expression) {
        return null;
    }

    @Override
    public Void visitGetExpression(Expression.Get expression) {
        return null;
    }

    @Override
    public Void visitSetExpression(Expression.Set expression) {
        return null;
    }

    @Override
    public Void visitThisExpression(Expression.This expression) {
        return null;
    }

    @Override
    public Void visitSuperExpression(Expression.Super expression) {
        return null;
    }
}
