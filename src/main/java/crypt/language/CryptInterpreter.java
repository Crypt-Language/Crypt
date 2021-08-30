package crypt.language;

import crypt.language.error.RuntimeError;
import crypt.language.lexer.token.Token;
import crypt.language.parser.AST.Expression;
import crypt.language.parser.AST.Statement;
import crypt.language.parser.environments.CryptCallable;
import crypt.language.parser.environments.type.classType.CryptClass;
import crypt.language.parser.environments.type.classType.CryptInstance;
import crypt.language.parser.environments.type.functionType.CryptFunction;
import crypt.language.parser.environments.Environment;
import crypt.language.parser.environments.type.functionType.FunctionType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static crypt.language.lexer.token.TokenType.*;

public class CryptInterpreter implements Expression.Visitor<Object>, Statement.Visitor<Void> {
    private final Map<Expression, Integer> locals = new HashMap<>();

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
    public Object visit(Expression expression) throws IOException {
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
    public Void visit(Statement statement) throws IOException {
        if(statement instanceof Statement.Print) return visitPrintStatement((Statement.Print) statement);
        if(statement instanceof Statement.Println) return visitPrintlnStatement((Statement.Println) statement);
        if(statement instanceof Statement.ExpressionStatement) return visitExpressionStatement((Statement.ExpressionStatement) statement);
        if(statement instanceof Statement.Variable) return visitVariableDeclaration((Statement.Variable) statement);
        if(statement instanceof Statement.Block) return visitBlockStatement((Statement.Block) statement);
        if(statement instanceof Statement.If) return visitIfStatement((Statement.If) statement);
        if(statement instanceof Statement.While) return visitWhileStatement((Statement.While) statement);
        if(statement instanceof Statement.Function) return visitFunctionDeclaration((Statement.Function) statement);
        if(statement instanceof Statement.Return) return visitReturnStatement((Statement.Return) statement);
        if(statement instanceof Statement.Class) return visitClassDeclaration((Statement.Class) statement);
        if(statement instanceof Statement.Input) return visitInputStatement((Statement.Input) statement);
        throw new Error("Statement not found");
    }

    /*
     * =======================================
     * Expression Interpreting
     * =======================================
     */

    @Override
    public Object visitBinaryExpression(Expression.Binary expression) throws IOException {
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

            case POW:
                checkNumberOperands(expression.operator, left, right);
                return Math.pow((double) left, (double) right);

            case ROOT:
                checkNumberOperands(expression.operator, left, right);
                return Math.sqrt((double) right);

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
    public Object visitGroupingExpression(Expression.Grouping expression) throws IOException {
        return evaluate(expression.expression);
    }

    @Override
    public Object visitLiteralExpression(Expression.Literal expression) {
        return expression.value;
    }

    @Override
    public Object visitUnaryExpression(Expression.Unary expression) throws IOException {
        Object right = evaluate(expression.right);

        switch (expression.operator.type) {
            case MINUS:
                checkNumberOperand(expression.operator, right);
                return -(double)right;

            case NOT:
                return !isTruthy(right);

            case ROOT:
                checkNumberOperand(expression.operator, right);
                return Math.sqrt((double) right);
        }

        // Unreachable.
        return null;
    }

    @Override
    public Object visitVariableReference(Expression.Variable expression) {
        return lookUpVariable(expression.name, expression);
        //return environment.get(expression.name);
    }

    @Override
    public Object visitAssignment(Expression.Assignment expression) throws IOException {
        Object value = evaluate(expression.value);

        //environment.assign(expression.name, expression);


        Integer distance = locals.get(expression);
        if (distance != null) {
            environment.assignAt(distance, expression.name, value);
        } else {
            globals.assign(expression.name, value);
        }


        return value;
    }

    @Override
    public Object visitLogicalExpression(Expression.Logical expression) throws IOException {
        Object left = evaluate(expression.left);

        if (expression.operator.type == OR) {
            if (isTruthy(left)) return left;
        } else {
            if (!isTruthy(left)) return left;
        }

        return evaluate(expression.right);
    }

    @Override
    public Object visitCallExpression(Expression.Call expression) throws IOException {
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

    @Override
    public Object visitGetExpression(Expression.Get expression) throws IOException {
        Object object = evaluate(expression.object);
        if (object instanceof CryptInstance) {
            return ((CryptInstance) object).get(expression.name);
        }

        throw new RuntimeError(expression.name, "Only instances have properties.");
    }

    @Override
    public Object visitSetExpression(Expression.Set expression) throws IOException {
        Object object = evaluate(expression.object);

        if (!(object instanceof CryptInstance)) {
            throw new RuntimeError(expression.name,
                    "Only instances have fields.");
        }

        Object value = evaluate(expression.value);
        ((CryptInstance)object).set(expression.name, value);
        return value;
    }

    @Override
    public Object visitThisExpression(Expression.This expression) {
        return null;
    }

    @Override
    public Object visitSuperExpression(Expression.Super expression) {
        int distance = locals.get(expression);

        CryptClass superClass = (CryptClass)environment.getAt(distance, "super");
        CryptInstance object = (CryptInstance)environment.getAt(distance - 1, "this");
        CryptFunction method = superClass.findMethod(expression.method.lexeme);

        if (method == null) throw new RuntimeError(expression.method, "Undefined property '" + expression.method.lexeme + "'.");

        return method.bind(object);
    }

    /*
     * ============================
     * Statement Interpreting
     * ============================
     */

    @Override
    public Void visitPrintStatement(Statement.Print printStatement) throws IOException {
        Object value = evaluate(printStatement.expression);
        System.out.print(stringify(value));
        return null;
    }

    @Override
    public Void visitPrintlnStatement(Statement.Println printlnStatement) throws IOException {
        Object value = evaluate(printlnStatement.expression);
        System.out.println(stringify(value));
        return null;
    }

    @Override
    public Void visitExpressionStatement(Statement.ExpressionStatement expressionStatement) throws IOException {
        evaluate(expressionStatement.expression);
        return null;
    }

    @Override
    public Void visitVariableDeclaration(Statement.Variable statement) throws IOException {
        Object value = null;
        if (statement.initializer != null) {
            value = evaluate(statement.initializer);
        }

        environment.define(statement.name.lexeme, value);
        return null;
    }

    @Override
    public Void visitBlockStatement(Statement.Block statement) throws IOException {
        executeBlock(statement.statements, new Environment(environment));
        return null;
    }

    @Override
    public Void visitIfStatement(Statement.If statement) throws IOException {
        if (isTruthy(evaluate(statement.condition))) execute(statement.thenStatement);
        else if (statement.elseStatement != null) execute(statement.elseStatement);

        return null;
    }

    @Override
    public Void visitWhileStatement(Statement.While statement) throws IOException {
        while (isTruthy(evaluate(statement.condition))) {
            execute(statement.body);
        }
        return null;
    }

    @Override
    public Void visitFunctionDeclaration(Statement.Function statement) {
        CryptFunction function = new CryptFunction(statement, environment, false);
        environment.define(statement.name.lexeme, function);
        return null;
    }

    @Override
    public Void visitReturnStatement(Statement.Return statement) throws IOException {
        Object value = null;
        if (statement.value != null) value = evaluate(statement.value);

        throw new Return(value);
    }

    @Override
    public Void visitClassDeclaration(Statement.Class statement) throws IOException {
        Object superClass = null;
        if (statement.superClass != null) {
            superClass = evaluate(statement.superClass);
            if (!(superClass instanceof CryptClass)) {
                throw new RuntimeError(statement.superClass.name, "Superclass must be a class.");
            }
        }

        environment.define(statement.name.lexeme, null);

        if (statement.superClass != null) {
            environment = new Environment(environment);
            environment.define("super", superClass);
        }

        Map<String, CryptFunction> methods = new HashMap<>();
        for (Statement.Function method : statement.methods) {
            CryptFunction function = new CryptFunction(method, environment, method.name.lexeme.equals("init"));
            methods.put(method.name.lexeme, function);
        }

        CryptClass type = new CryptClass(statement.name.lexeme, (CryptClass) superClass, methods);

        if (superClass != null) {
            environment = environment.enclosing;
        }

        environment.assign(statement.name, type);
        return null;
    }

    @Override
    public Void visitInputStatement(Statement.Input statement) throws IOException {
        Object value = evaluate(statement.expression);
        System.out.print(stringify(value));

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        String userInput = reader.readLine();

        evaluate(new Expression.Literal(userInput));

        return null;
    }

    /*
     * ============================
     * Helper functions
     * ============================
     */
    Object evaluate(Expression expr) throws IOException {
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

    void interpret(List<Statement> statements) throws IOException {
        try {
            for (Statement statement : statements) {
                execute(statement);
            }
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

    void execute(Statement stmt) throws IOException {
        stmt.accept(this);
    }

    public void executeBlock(List<Statement> statements, Environment environment) throws IOException {
        Environment previous = this.environment;

        try {
            this.environment = environment;
            for (Statement statement : statements) {
                execute(statement);
            }
        } finally {
            this.environment = previous;
        }
    }

    public void resolve(Expression expr, int depth) {
        locals.put(expr, depth);
    }

    private Object lookUpVariable(Token name, Expression expr) {
        Integer distance = locals.get(expr);
        if (distance != null) {
            return environment.getAt(distance, name.lexeme);
        } else {
            return globals.get(name);
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
