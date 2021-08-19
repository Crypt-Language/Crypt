package crypt.language;

import crypt.language.error.RuntimeError;
import crypt.language.lexer.token.Token;
import crypt.language.parser.AST.Expression;
import crypt.language.parser.AST.Statement;
import crypt.language.parser.environments.CryptCallable;
import crypt.language.parser.environments.CryptFunction;
import crypt.language.parser.environments.Environment;

import java.util.ArrayList;
import java.util.List;

import static crypt.language.lexer.token.TokenType.*;

public class CryptInterpreter implements Expression.Visitor<Object>, Statement.Visitor<Void> {
    public final Environment globals = new Environment();
    private Environment environment = globals;
    public static boolean hadRuntimeError = false;

    public CryptInterpreter(){
        globals.define("clock", new CryptCallable() {
            @Override
            public int arity() { return 0; }

            @Override
            public Object call(CryptInterpreter interpreter, List<Object> arguments) {
                return (double)System.currentTimeMillis() / 1000.0;
            }

            @Override
            public String toString() { return "<native fn>"; }
        });
    }

    @Override
    public Object visit(Expression expression){
        if(expression instanceof Expression.Binary) return visitBinaryExpression((Expression.Binary)expression);
        if(expression instanceof Expression.Unary) return visitUnaryExpression((Expression.Unary)expression);
        if(expression instanceof Expression.Grouping) return visitGroupingExpression((Expression.Grouping) expression);
        if(expression instanceof Expression.Literal) return visitLiteralExpression((Expression.Literal) expression);
        if(expression instanceof Expression.Variable) return visitVariableReference((Expression.Variable) expression);
        if(expression instanceof Expression.Assignment) return visitAssignment((Expression.Assignment) expression);
        if(expression instanceof Expression.Logical) return visitLogicalExpression((Expression.Logical) expression);
        if(expression instanceof Expression.Call) return visitCallExpression((Expression.Call) expression);
        throw new Error("Expression not found");
    }


    @Override
    public Void visit(Statement statement) {
        if(statement instanceof Statement.Print) return visitPrintStatement((Statement.Print) statement);
        if(statement instanceof Statement.Println) return visitPrintlnStatement((Statement.Println) statement);
        if(statement instanceof Statement.ExpressionStatement) return visitExpressionStatement((Statement.ExpressionStatement) statement);
        if(statement instanceof Statement.Variable) return visitVariableDeclaration((Statement.Variable) statement);
        if(statement instanceof Statement.Block) return visitBlockStatement((Statement.Block) statement);
        if(statement instanceof Statement.If) return visitIfStatement((Statement.If) statement);
        if(statement instanceof Statement.While) return visitWhileStatement((Statement.While) statement);
        if(statement instanceof Statement.Function) return visitFunctionDeclaration((Statement.Function) statement);
        if(statement instanceof Statement.Return) return visitReturnStatement((Statement.Return) statement);
        throw new Error("Statement not found");
    }

    /*
    * =======================================
    * Expression Interpreting
    * =======================================
    */

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

    @Override
    public Object visitVariableReference(Expression.Variable expression) {
        return environment.get(expression.name);
    }

    @Override
    public Object visitAssignment(Expression.Assignment expression) {
        Object value = evaluate(expression.value);
        environment.assign(expression.name, value);
        return value;
    }

    @Override
    public Object visitLogicalExpression(Expression.Logical expression) {
        Object left = evaluate(expression.left);

        if (expression.operator.type == OR) {
            if (isTruthy(left)) return left;
        } else {
            if (!isTruthy(left)) return left;
        }

        return evaluate(expression.right);
    }

    @Override
    public Object visitCallExpression(Expression.Call expression) {
        Object callee = evaluate(expression.callee);

        List<Object> arguments = new ArrayList<>();
        for (Expression argument : expression.arguments) {
            arguments.add(evaluate(argument));
        }

        if (!(callee instanceof CryptCallable))
            throw new RuntimeError(expression.paren, "Can only call functions and classes.");


        CryptCallable function = (CryptCallable)callee;

        if (arguments.size() != function.arity()) {
            throw new RuntimeError(expression.paren, "Expected " +
                    function.arity() + " arguments but got " +
                    arguments.size() + ".");
        }

        return function.call(this, arguments);
    }

    /*
    * ============================
    * Statement Interpreting
    * ============================
    */

    @Override
    public Void visitPrintStatement(Statement.Print printStatement) {
        Object value = evaluate(printStatement.expression);
        System.out.print(stringify(value));
        return null;
    }

    @Override
    public Void visitPrintlnStatement(Statement.Println printlnStatement) {
        Object value = evaluate(printlnStatement.expression);
        System.out.println(stringify(value));
        return null;
    }

    @Override
    public Void visitExpressionStatement(Statement.ExpressionStatement expressionStatement) {
        evaluate(expressionStatement.expression);
        return null;
    }

    @Override
    public Void visitVariableDeclaration(Statement.Variable statement) {
        Object value = null;
        if (statement.initializer != null) {
            value = evaluate(statement.initializer);
        }

        environment.define(statement.name.lexeme, value);
        return null;
    }

    @Override
    public Void visitBlockStatement(Statement.Block statement) {
        executeBlock(statement.statements, new Environment(environment));
        return null;
    }

    @Override
    public Void visitIfStatement(Statement.If statement) {
        if (isTruthy(evaluate(statement.condition))) execute(statement.thenStatement);
        else if (statement.elseStatement != null) execute(statement.elseStatement);

        return null;
    }

    @Override
    public Void visitWhileStatement(Statement.While statement) {
        while (isTruthy(evaluate(statement.condition))) {
            execute(statement.body);
        }
        return null;
    }

    @Override
    public Void visitFunctionDeclaration(Statement.Function statement) {
        CryptFunction function = new CryptFunction(statement, environment);
        environment.define(statement.name.lexeme, function);
        return null;
    }

    @Override
    public Void visitReturnStatement(Statement.Return statement) {
        Object value = null;
        if (statement.value != null) value = evaluate(statement.value);

        throw new Return(value);
    }

    /*
     * ============================
     * Helper functions
     * ============================
     */
    Object evaluate(Expression expr) {
        return expr.accept(this);
    }

    boolean isTruthy(Object object) {
        if (object == null) return false;
        if (object instanceof Boolean) return (boolean)object;
        return true;
    }

    boolean isEqual(Object a, Object b) {
        if (a == null && b == null) return true;
        if (a == null) return false;

        return a.equals(b);
    }

    void checkNumberOperand(Token operator, Object operand) {
        if (operand instanceof Double) return;
        throw new RuntimeError(operator, "Operand must be a number.");
    }

    void checkNumberOperands(Token operator,
                                     Object left, Object right) {
        if (left instanceof Double && right instanceof Double) return;

        throw new RuntimeError(operator, "Operands must be numbers.");
    }

    void interpret(List<Statement> statements) {
        try {
            statements.forEach(this::execute);
        } catch (RuntimeError error) {
            Crypt.runtimeError(error);
        }
    }

    String stringify(Object object) {
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

    void execute(Statement stmt) {
        stmt.accept(this);
    }

    public void executeBlock(List<Statement> statements, Environment environment) {
        Environment previous = this.environment;

        try {
            this.environment = environment;
            statements.forEach(this::execute);
        } finally {
            this.environment = previous;
        }
    }

    /*
    * RETURN
    * ERROR
    */

    public class Return extends RuntimeException {
        public final Object value;

        Return(Object value) {
            super(null, null, false, false);
            this.value = value;
        }
    }
}
