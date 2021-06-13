package CryptCompiler.utils;

import CryptCompiler.Lexer.token.Token;

import java.util.List;
import java.util.Optional;

public abstract class Statement {
    public static class Print extends Statement {
        public Print(Expression value){
            this.value = value;
        }

        final Expression value;

        @Override
        <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Println extends Statement {
        public Println(Expression value){
            this.value = value;
        }

        final Expression value;

        @Override
        <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class ExpressionStatement extends Statement {
        public ExpressionStatement(Expression expression){
            this.expression = expression;
        }

        final Expression expression;

        @Override
        <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class VariableDeclaration extends Statement {
        public VariableDeclaration(Token name, Expression initializer, Token type){
            this.name = name;
            this.initializer = initializer;
            this.type = type;
        }

        final Token name;
        final Expression initializer;
        final Token type;
        @Override
        <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Block extends Statement {
        public Block(List<Statement> statementList){
            this.statementList = statementList;
        }

        final List<Statement> statementList;

        @Override
        <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class If extends Statement {
        public If(Expression condition, Statement thenStatement, Statement elseStatement){
            this.condition = condition;
            this.thenStatement = thenStatement;
            this.elseStatement = elseStatement;
        }

        final Expression condition;
        final Statement thenStatement;
        final Statement elseStatement;

        @Override
        <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class While extends Statement {
        public While(Expression condition, Statement body){
            this.condition = condition;
            this.body = body;
        }

        final Expression condition;
        final Statement body;

        @Override
        <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    abstract <T> T accept(Visitor<T> visitor);

    interface Visitor<T> {
        T visitPrintStatement();
        T visitPrintlnStatement();
        T visitExpressionStatement();
        T visitVariableDeclarationStatement();
        T visitBlockStatement();
        T visitIfStatement();
        T visitWhileStatement();

        T visit(Statement statement);
    }
}
