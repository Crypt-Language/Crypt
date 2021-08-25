package crypt.language.parser.AST;

import crypt.language.lexer.token.Token;

import javax.swing.plaf.nimbus.State;
import java.util.List;

public abstract class Statement {
    public abstract <T> T accept(Statement.Visitor<T> visitor);

    public static class Print extends Statement{
        public Print(Expression expression){
            this.expression = expression;
        }

        public Expression expression;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Println extends Statement{
        public Println(Expression expression){
            this.expression = expression;
        }

        public Expression expression;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class ExpressionStatement extends Statement {
        public ExpressionStatement(Expression expression){
            this.expression = expression;
        }

        public Expression expression;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Variable extends Statement {
        public Variable(Token name, Expression initializer){
            this.name = name;
            this.initializer = initializer;
        }

        public Token name;
        public Expression initializer;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Block extends Statement {
        public Block(List<Statement> statements){
            this.statements = statements;
        }

        public List<Statement> statements;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class If extends Statement {
        public If(Expression condition, Statement thenStatement, Statement elseStatement){
            this.condition = condition;
            this.thenStatement = thenStatement;
            this.elseStatement = elseStatement;
        }

        public Expression condition;
        public Statement thenStatement;
        public Statement elseStatement;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class While extends Statement {
        public While(Expression condition, Statement body){
            this.condition = condition;
            this.body = body;
        }

        public Expression condition;
        public Statement body;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Function extends Statement {
        public Function(Token name, List<Token> parameters, List<Statement> body){
            this.name = name;
            this.parameters = parameters;
            this.body = body;
        }

        public Token name;
        public List<Token> parameters;
        public List<Statement> body;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Return extends Statement {
        public Return(Token keyword, Expression value){
            this.keyword = keyword;
            this.value = value;
        }

        public Token keyword;
        public Expression value;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Class extends Statement {
        public Class(Token name, Expression.Variable superClass, List<Statement.Function> methods){
            this.name = name;
            this.methods = methods;
            this.superClass = superClass;
        }

        public Token name;
        public List<Statement.Function> methods;
        public Expression.Variable superClass;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public interface Visitor<T> {
        T visit(Statement statement);
        T visitPrintStatement(Statement.Print printStatement);
        T visitPrintlnStatement(Statement.Println printlnStatement);
        T visitExpressionStatement(Statement.ExpressionStatement expressionStatement);
        T visitVariableDeclaration(Statement.Variable statement);
        T visitBlockStatement(Statement.Block statement);
        T visitIfStatement(Statement.If statement);
        T visitWhileStatement(Statement.While statement);
        T visitFunctionDeclaration(Statement.Function statement);
        T visitReturnStatement(Statement.Return statement);
        T visitClassDeclaration(Statement.Class statement);
    }
}
