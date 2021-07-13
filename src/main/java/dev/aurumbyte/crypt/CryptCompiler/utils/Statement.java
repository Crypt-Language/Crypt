package dev.aurumbyte.crypt.CryptCompiler.utils;

import dev.aurumbyte.crypt.CryptCompiler.Lexer.token.Token;

import java.util.List;

public abstract class Statement {
    public static class Print extends Statement {
        public Print(Expression value){
            this.value = value;
        }

        public final Expression value;

        @Override
        <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Println extends Statement {
        public Println(Expression value){
            this.value = value;
        }

        public final Expression value;

        @Override
        <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class ExpressionStatement extends Statement {
        public ExpressionStatement(Expression expression){
            this.expression = expression;
        }

        public final Expression expression;

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

        public final Token name;
        public final Expression initializer;
        public final Token type;
        @Override
        <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Block extends Statement {
        public Block(List<Statement> statementList){
            this.statementList = statementList;
        }

        public final List<Statement> statementList;

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

        public final Expression condition;
        public final Statement thenStatement;
        public final Statement elseStatement;

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

        public final Expression condition;
        public final Statement body;

        @Override
        <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    abstract <T> T accept(Visitor<T> visitor);

    public interface Visitor<T> {
        T visitPrintStatement(Print statement);
        T visitPrintlnStatement(Println statement);
        T visitExpressionStatement(ExpressionStatement statement);
        T visitVariableDeclarationStatement(VariableDeclaration statement);
        T visitBlockStatement(Block statement);
        T visitIfStatement(If statement);
        T visitWhileStatement(While statement);

        T visit(Statement statement);
    }
}
