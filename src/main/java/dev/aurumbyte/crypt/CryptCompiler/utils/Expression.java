package dev.aurumbyte.crypt.CryptCompiler.utils;

import dev.aurumbyte.crypt.CryptCompiler.Lexer.token.Token;

import java.util.List;

public abstract class Expression {

    public static class Binary extends Expression {
        public Binary(Expression left, Token operator, Expression right) {
            this.left = left;
            this.operator = operator;
            this.right = right;
        }

        public final Expression left;
        public final Token operator;
        public final Expression right;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Literal extends Expression {
        public Literal(Object literal){
            this.literal = literal;
        }

        public final Object literal;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Grouping extends Expression {
        public Grouping(Expression expression){
            this.expression = expression;
        }

        public final Expression expression;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Unary extends Expression{
        public Unary(Token operator, Expression expression){
            this.operator = operator;
            this.right = expression;
        }

        public final Token operator;
        public final Expression right;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Variable extends Expression {
        public Variable(Token name){
            this.name = name;
        }

        public final Token name;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Assign extends Expression {
        public Assign(Token name, Expression value){
            this.name = name;
            this.value = value;
        }

        public final Token name;
        public final Expression value;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Logical extends Expression {
        public Logical(Expression left, Token operator, Expression right) {
            this.left = left;
            this.operator = operator;
            this.right = right;
        }

        public final Expression left;
        public final Token operator;
        public final Expression right;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Call extends Expression {
        public Call(Expression callee, Token paren, List<Expression> arguments){
            this.callee = callee;
            this.paren = paren;
            this.arguments = arguments;
        }

        public final Expression callee;
        public final Token paren;
        public final List<Expression> arguments;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public abstract <T> T accept(Visitor<T> visitor);

    public interface Visitor<T> {
        T visitBinaryExpression(Binary expression);
        T visitLiteralExpression(Literal expression);
        T visitUnaryExpression(Unary expression);
        T visitGrouping(Grouping expression);
        T visitVariableExpression(Variable expression);
        T visitLogicalExpression(Logical expression);
        T visitCallExpression(Call expression);

        T visit(Expression expression);
    }
}
