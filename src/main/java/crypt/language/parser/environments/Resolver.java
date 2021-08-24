package crypt.language.parser.environments;

import crypt.language.Crypt;
import crypt.language.CryptInterpreter;
import crypt.language.lexer.token.Token;
import crypt.language.parser.AST.Expression;
import crypt.language.parser.AST.Statement;
import crypt.language.parser.environments.type.classType.ClassType;
import crypt.language.parser.environments.type.functionType.FunctionType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Resolver implements Expression.Visitor<Object>, Statement.Visitor<Void> {
    private final CryptInterpreter interpreter;
    private FunctionType currentFunction = FunctionType.NONE;
    private final Stack<Map<String, Boolean>> scopes = new Stack<>();

    private ClassType currentClass = ClassType.NONE;

    public Resolver(CryptInterpreter interpreter){
        this.interpreter = interpreter;
        scopes.push(new HashMap<>());
    }

    /*
     * =================================================
     * EXPRESSIONS
     * =================================================
     */
    @Override
    public Object visit(Expression expression) {
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
        if(expression instanceof Expression.Super) return visitSuperExpression((Expression.Super) expression);
        throw new Error("Expression not resolved");
    }

    @Override
    public Object visitBinaryExpression(Expression.Binary expression) {
        resolve(expression.left);
        resolve(expression.right);
        return null;
    }

    @Override
    public Object visitGroupingExpression(Expression.Grouping expression) {
        resolve(expression.expression);
        return null;
    }

    @Override
    public Object visitLiteralExpression(Expression.Literal expression) {
        return null;
    }

    @Override
    public Object visitUnaryExpression(Expression.Unary expression) {
        resolve(expression.right);
        return null;
    }

    @Override
    public Object visitVariableReference(Expression.Variable expression) {
        if (!scopes.isEmpty() &&
                scopes.peek().get(expression.name.lexeme) == Boolean.FALSE) {
            Crypt.error(expression.name.line, "Can't read local variable in its own initializer.");
        }

        resolveLocal(expression, expression.name);
        return null;
    }

    @Override
    public Object visitAssignment(Expression.Assignment expression) {
        resolve(expression.value);
        resolveLocal(expression, expression.name);
        return null;
    }

    @Override
    public Object visitLogicalExpression(Expression.Logical expression) {
        resolve(expression.left);
        resolve(expression.right);
        return null;
    }

    @Override
    public Object visitCallExpression(Expression.Call expression) {
        resolve(expression.callee);
        for (Expression argument : expression.arguments) resolve(argument);
        return null;
    }

    @Override
    public Object visitGetExpression(Expression.Get expression) {
        resolve(expression.object);
        return null;
    }

    @Override
    public Object visitSetExpression(Expression.Set expression) {
        resolve(expression.value);
        resolve(expression.object);
        return null;
    }

    @Override
    public Object visitThisExpression(Expression.This expression) {
        return null;
    }

    @Override
    public Object visitSuperExpression(Expression.Super expression) {
        if (currentClass == ClassType.NONE) {
            Crypt.error(expression.keyword.line,
                    "Can't use 'super' outside of a class.");
        } else if (currentClass != ClassType.SUBCLASS) {
            Crypt.error(expression.keyword.line,
                    "Can't use 'super' in a class with no superclass.");
        }
        resolveLocal(expression, expression.keyword);
        return null;
    }

    /*
    * =================================================
    * STATEMENTS
    * =================================================
    */

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
        if(statement instanceof Statement.Class) return visitClassDeclaration((Statement.Class) statement);
        throw new Error("Statement not resolved");
    }

    @Override
    public Void visitPrintStatement(Statement.Print printStatement) {
        resolve(printStatement.expression);
        return null;
    }

    @Override
    public Void visitPrintlnStatement(Statement.Println printlnStatement) {
        resolve(printlnStatement.expression);
        return null;
    }

    @Override
    public Void visitExpressionStatement(Statement.ExpressionStatement expressionStatement) {
        resolve(expressionStatement.expression);
        return null;
    }

    @Override
    public Void visitVariableDeclaration(Statement.Variable statement) {
        declare(statement.name);
        if (statement.initializer != null) {
            resolve(statement.initializer);
        }
        define(statement.name);
        return null;
    }

    @Override
    public Void visitBlockStatement(Statement.Block statement) {
        beginScope();
        resolve(statement.statements);
        endScope();
        return null;
    }

    @Override
    public Void visitIfStatement(Statement.If statement) {
        resolve(statement.condition);
        resolve(statement.thenStatement);
        if (statement.elseStatement != null) resolve(statement.elseStatement);
        return null;
    }

    @Override
    public Void visitWhileStatement(Statement.While statement) {
        resolve(statement.condition);
        resolve(statement.body);
        return null;
    }

    @Override
    public Void visitFunctionDeclaration(Statement.Function statement) {
        declare(statement.name);
        define(statement.name);

        resolveFunction(statement, FunctionType.FUNCTION);
        return null;
    }

    @Override
    public Void visitReturnStatement(Statement.Return statement) {
        if (currentFunction == FunctionType.NONE) Crypt.error(statement.keyword.line, "Can't return from top-level code.");

        if (statement.value != null){
            if (currentFunction == FunctionType.INITIALIZER) {
                Crypt.error(statement.keyword.line, "Can't return a value from an initializer.");
            }
            resolve(statement.value);
        }
        return null;
    }

    @Override
    public Void visitClassDeclaration(Statement.Class statement) {
        ClassType enclosingClass = currentClass;
        currentClass = ClassType.CLASS;

        declare(statement.name);
        define(statement.name);

        if (statement.superClass != null &&
                statement.name.lexeme.equals(statement.superClass.name.lexeme)) {
            Crypt.error(statement.superClass.name.line,
                    "A class can't inherit from itself.");
        }

        if (statement.superClass != null) {
            currentClass = ClassType.SUBCLASS;
            beginScope();
            scopes.peek().put("super", true);
        }
        scopes.peek().put("this", true);

        for (Statement.Function method : statement.methods) {
            FunctionType declaration = FunctionType.METHOD;
            if (method.name.lexeme.equals("init")) {
                declaration = FunctionType.INITIALIZER;
            }
            resolveFunction(method, declaration);
        }
        if (statement.superClass != null) endScope();

        currentClass = enclosingClass;
        return null;
    }

    /*
     * =================================================
     * Helpers
     * =================================================
     */

    public void resolve(List<Statement> statements) {
        for (Statement statement : statements) {
            resolve(statement);
        }
    }

    private void resolve(Statement stmt) {
        stmt.accept(this);
    }

    private void resolve(Expression expr) {
        expr.accept(this);
    }

    private void beginScope() {
        scopes.push(new HashMap<>());
    }

    private void endScope() {
        scopes.pop();
    }

    private void declare(Token name) {
        if (scopes.isEmpty()) return;

        Map<String, Boolean> scope = scopes.peek();
        if (scope.containsKey(name.lexeme)) Crypt.error(name.line, "Already a variable with this name in this scope.");

        scope.put(name.lexeme, false);
    }

    private void define(Token name) {
        if (scopes.isEmpty()) return;
        scopes.peek().put(name.lexeme, true);
    }

    private void resolveLocal(Expression expr, Token name) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            if (scopes.get(i).containsKey(name.lexeme)) {
                interpreter.resolve(expr, scopes.size() - 1 - i);
                return;
            }
        }
    }

    private void resolveFunction(Statement.Function function, FunctionType type) {
        FunctionType enclosingFunction = currentFunction;
        currentFunction = type;

        beginScope();
        for (Token param : function.parameters) {
            declare(param);
            define(param);
        }

        resolve(function.body);
        endScope();

        currentFunction = enclosingFunction;
    }
}
