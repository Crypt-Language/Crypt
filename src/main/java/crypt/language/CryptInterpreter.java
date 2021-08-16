package crypt.language;

import crypt.language.error.RuntimeError;
import crypt.language.lexer.token.Token;
import crypt.language.parser.AST.Expression;

public class CryptInterpreter implements Expression.Visitor<Object>{
    public static boolean hadRuntimeError = false;

    @Override
    public Object visit(Expression expression){
        if(expression instanceof Expression.Binary) return visitBinaryExpression((Expression.Binary)expression);
        if(expression instanceof Expression.Unary) return visitUnaryExpression((Expression.Unary)expression);
        if(expression instanceof Expression.Grouping) return visitGroupingExpression((Expression.Grouping) expression);
        if(expression instanceof Expression.Literal) return visitLiteralExpression((Expression.Literal) expression);
        throw new Error("Expression not found");
    }

    @Override
    public Object visitBinaryExpression(Expression.Binary expression) {
        Object left = evaluate(expression.left);
        Object right = evaluate(expression.right);

        switch (expression.operator.type) {
            case MINUS:
                checkNumberOperands(expression.operator, left, right);
                return (double)left - (double)right;

            case SLASH:
                checkNumberOperands(expression.operator, left, right);
                return (double)left / (double)right;

            case ASTERISK:
                checkNumberOperands(expression.operator, left, right);
                return (double)left * (double)right;

            case PLUS:
                if (left instanceof Double && right instanceof Double) return (double)left + (double)right;
                else if (left instanceof String && right instanceof String) return (String) left + (String) right;
                throw new RuntimeError(expression.operator, "Operands must be two numbers or two strings.");

                // Comparision

            case GREATER:
                checkNumberOperands(expression.operator, left, right);
                return (double)left > (double)right;

            case GREATER_OR_EQUAL:
                checkNumberOperands(expression.operator, left, right);
                return (double)left >= (double)right;

            case LESS:
                checkNumberOperands(expression.operator, left, right);
                return (double)left < (double)right;

            case LESS_OR_EQUAL:
                checkNumberOperands(expression.operator, left, right);
                return (double)left <= (double)right;

            // Equality

            case NOT_EQUAL: return !isEqual(left, right);
            case EQUALS: return isEqual(left, right);
        }

        // Unreachable.
        return null;
    }

    @Override
    public Object visitGroupingExpression(Expression.Grouping expression) {
        return evaluate(expression.expression);
    }

    @Override
    public Object visitLiteralExpression(Expression.Literal expression) {
        return expression.value;
    }

    @Override
    public Object visitUnaryExpression(Expression.Unary expression) {
        Object right = evaluate(expression.right);

        switch (expression.operator.type) {
            case MINUS:
                checkNumberOperand(expression.operator, right);
                return -(double)right;

            case NOT:
                return !isTruthy(right);
        }

        // Unreachable.
        return null;
    }

    /*
     * ============================
     * Helper functions
     * ============================
     */
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

    private void checkNumberOperand(Token operator, Object operand) {
        if (operand instanceof Double) return;
        throw new RuntimeError(operator, "Operand must be a number.");
    }

    private void checkNumberOperands(Token operator,
                                     Object left, Object right) {
        if (left instanceof Double && right instanceof Double) return;

        throw new RuntimeError(operator, "Operands must be numbers.");
    }

    void interpret(Expression expression) {
        try {
            Object value = evaluate(expression);
            System.out.println(stringify(value));
        } catch (RuntimeError error) {
            runtimeError(error);
        }
    }

    private String stringify(Object object) {
        if (object == null) return "nil";

        if (object instanceof Double) {
            String text = object.toString();
            if (text.endsWith(".0")) {
                text = text.substring(0, text.length() - 2);
            }
            return text;
        }

        return object.toString();
    }

    static void runtimeError(RuntimeError error) {
        System.err.println(error.getMessage() +
                "\n[line " + error.token.line + "]");
        hadRuntimeError = true;
    }
}
