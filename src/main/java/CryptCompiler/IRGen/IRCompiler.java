package CryptCompiler.IRGen;

import CryptCompiler.Lexer.token.Token;
import CryptCompiler.utils.*;

import java.util.ArrayList;
import java.util.List;
import static CryptCompiler.utils.CryptIR.*;



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
                cryptIR.add(null);
                cryptIR.add(IFGT);
                break;
            case GREATER_OR_EQUAL:
                return (double)left >= (double)right;
            case LESS_THAN:
                return (double)left < (double)right;
            case LESS_OR_EQUAL:
                return (double)left <= (double)right;
            case MINUS:
                return (double)left - (double)right;
            case SLASH:
                return (double)left / (double)right;
            case ASTERISK:
                return (double)left * (double)right;

            case NOT_EQUAL: return !isEqual(left, right);
            case EQUALS: return isEqual(left, right);

            case PLUS:
                if (left instanceof Double && right instanceof Double) {
                    return (double)left + (double)right;
                }

                if (left instanceof String && right instanceof String) {
                    return left + (String)right;
                }

                break;
        }


        return null;
    }

    @Override
    public Object visitLiteralExpression(Expression.Literal expression) {
        return expression.literal;
    }

    @Override
    public Object visitUnaryExpression(Expression.Unary expression) {
        Object right = evaluate(expression.right);

        switch (expression.operator.type) {
            case MINUS:
                return -(double)right;
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

}
