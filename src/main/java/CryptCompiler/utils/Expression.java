package CryptCompiler.utils;

import CryptCompiler.Lexer.token.Token;

public abstract class Expression {

    public static class Binary extends Expression {
        public Binary(Expression left, Token operator, Expression right) {
            this.left = left;
            this.operator = operator;
            this.right = right;
        }

        final Expression left;
        final Token operator;
        final Expression right;

        @Override
        <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Literal extends Expression {
        public Literal(Object literal){
            this.literal = literal;
        }

        public final Object literal;

        @Override
        <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Grouping extends Expression {
        public Grouping(Expression expression){
            this.expression = expression;
        }

        final Expression expression;

        @Override
        <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Unary extends Expression{
        public Unary(Token operator, Expression expression){
            this.operator = operator;
            this.expression = expression;
        }

        final Token operator;
        final Expression expression;

        @Override
        <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Variable extends Expression {
        public Variable(Token name){
            this.name = name;
        }

        public final Token name;

        @Override
        <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Assign extends Expression {
        public Assign(Token name, Expression value){
            this.name = name;
            this.value = value;
        }

        final Token name;
        final Expression value;

        @Override
        <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Logical extends Expression {
        public Logical(Expression left, Token operator, Expression right) {
            this.left = left;
            this.operator = operator;
            this.right = right;
        }

        final Expression left;
        final Token operator;
        final Expression right;

        @Override
        <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    abstract <T> T accept(Visitor<T> visitor);

    interface Visitor<T> {
        T visitBinaryExpression();
        T visitLiteralExpression();
        T visitUnaryExpression();
        T visitGrouping();
        T visitVariableExpression();
        T visitLogicalExpression();

        T visit(Expression expression);
    }
}
