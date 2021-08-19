package crypt.language.parser.AST;

import crypt.language.lexer.token.Token;

import java.util.List;

public abstract class Expression {
    public abstract <T> T accept(Visitor<T> visitor);

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

    public static class Literal extends Expression {
        public Literal(Object value){
            this.value = value;
        }

        public final Object value;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Unary extends Expression {
        public Unary(Token operator, Expression right){
            this.operator = operator;
            this.right = right;
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

        public Token name;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Assignment extends Expression {
        public Assignment(Token name, Expression value){
            this.name = name;
            this.value = value;
        }

        public Token name;
        public Expression value;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public static class Logical extends Expression {
        public Logical(Expression left, Token operator, Expression right){
            this.left = left;
            this.operator = operator;
            this.right = right;
        }

        public Expression left;
        public Token operator;
        public Expression right;

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

        public Expression callee;
        public Token paren;
        public List<Expression> arguments;

        @Override
        public <T> T accept(Visitor<T> visitor){
            return visitor.visit(this);
        }
    }

    public interface Visitor<T> {
        T visit(Expression expression);
        T visitBinaryExpression(Expression.Binary expression);
        T visitGroupingExpression(Expression.Grouping expression);
        T visitLiteralExpression(Expression.Literal expression);
        T visitUnaryExpression(Expression.Unary expression);
        T visitVariableReference(Expression.Variable expression);
        T visitAssignment(Expression.Assignment expression);
        T visitLogicalExpression(Expression.Logical expression);
        T visitCallExpression(Expression.Call expression);
    }
}
