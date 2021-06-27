package CryptCompiler.utils;

import CryptCompiler.Lexer.token.Token;

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
        T visitBinaryExpression(Expression.Binary expression);
        T visitLiteralExpression(Expression.Literal expression);
        T visitUnaryExpression(Expression.Unary expression);
        T visitGrouping(Expression.Grouping expression);
        T visitVariableExpression(Expression.Variable expression);
        T visitLogicalExpression(Expression.Logical expression);
        T visitCallExpression(Expression.Call expression);

        T visit(Expression expression);
    }
}
