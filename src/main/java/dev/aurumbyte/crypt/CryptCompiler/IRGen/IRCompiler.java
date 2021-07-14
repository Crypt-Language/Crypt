package dev.aurumbyte.crypt.CryptCompiler.IRGen;

import dev.aurumbyte.crypt.CryptCompiler.Lexer.token.Token;
import dev.aurumbyte.crypt.CryptCompiler.utils.Expression;
import dev.aurumbyte.crypt.CryptCompiler.utils.RuntimeError;
import dev.aurumbyte.crypt.CryptCompiler.utils.Statement;
import dev.aurumbyte.crypt.CryptCompiler.utils.VariableSymbolTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static dev.aurumbyte.crypt.CryptCompiler.utils.CryptIR.*;
import static dev.aurumbyte.crypt.CryptCompiler.Lexer.token.TokenType.*;

public class IRCompiler implements Expression.Visitor<Object>, Statement.Visitor<Void> {

    private VariableSymbolTable variableSymbolTable = new VariableSymbolTable();
    public List<Object> cryptIR = new ArrayList<>();
    private final List<Statement> statements;

    public IRCompiler(List<Statement> statements){
        this.statements = statements;
    }

    @Override
    public Object visitBinaryExpression(Expression.Binary expression) {
        Object left = evaluate(expression.left);
        Object right = evaluate(expression.right);

        switch (expression.operator.type) {
            case GREATER_THAN:
                addCryptIR(left, IFGT, right);
                break;
            case GREATER_OR_EQUAL:
                addCryptIR(left, IFGE, right);
                break;
            case LESS_THAN:
                addCryptIR(left, IFLT, right);
                break;
            case LESS_OR_EQUAL:
                addCryptIR(left, IFLE, right);
                break;
            case MINUS:
                addCryptIR(left, SUB, right);
                break;
            case SLASH:
                addCryptIR(left, DIV, right);
                break;
            case ASTERISK:
                addCryptIR(left, MUL, right);
                break;

            case NOT_EQUAL: {
                if(!isEqual(left, right)){
                    addCryptIR(left, IFNE, right);
                }
                break;
            }
            case EQUALS: {
                if(isEqual(left, right)){
                    addCryptIR(left, IFEQ, right);
                }
                break;
            }

            case PLUS:
                if (left instanceof Double && right instanceof Double) {
                    addCryptIR(left, ADD, right);
                }

                if (left instanceof String && right instanceof String) {
                    addCryptIR(String.valueOf(left), ADD, String.valueOf(right));
                }

                break;
        }


        return null;
    }

    @Override
    public Object visitLiteralExpression(Expression.Literal expression) {
        addCryptIR(expression.literal);
        return null;
    }

    @Override
    public Object visitUnaryExpression(Expression.Unary expression) {
        Object right = evaluate(expression.right);

        switch (expression.operator.type) {
            case MINUS:
                addCryptIR(-(double)right);
        }

        // Unreachable.
        return null;
    }


    @Override
    public Object visitGrouping(Expression.Grouping expression) {
        return evaluate(expression.expression);
    }

    @Override
    public Object visitVariableExpression(Expression.Variable expression) {
        return null;
    }

    @Override
    public Object visitLogicalExpression(Expression.Logical expression) {
        return null;
    }

    @Override
    public Object visitCallExpression(Expression.Call expression){
        return null;
    }

    @Override
    public Object visit(Expression expression) {
        return null;
    }

    @Override
    public Void visitPrintStatement(Statement.Print statement) {
        return null;
    }

    @Override
    public Void visitPrintlnStatement(Statement.Println statement) {
        return null;
    }

    @Override
    public Void visitExpressionStatement(Statement.ExpressionStatement statement) {
        return null;
    }

    @Override
    public Void visitVariableDeclarationStatement(Statement.VariableDeclaration statement) {
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
    public Void visit(Statement statement) {
        return null;
    }


// Helpers
    private Object evaluate(Expression expr) {
        return expr.accept(this);
    }

    private boolean isTruthy(Object object) {
        if (object == null) return false;
        if (object instanceof Boolean) return (boolean)object;
        return true;
    }

    private boolean isEqual(Object a, Object b) {
        if (a == null && b == null) return true;
        if (a == null) return false;

        return a.equals(b);
    }

    private void checkNumberOperands(Token operator, Object operand) {
        if (operand instanceof Double) return;
        throw new RuntimeError(operator, "Operand must be a number.");
    }

    public void addCryptIR(Object... objects){
        cryptIR.addAll(Arrays.asList(objects));
    }

}
