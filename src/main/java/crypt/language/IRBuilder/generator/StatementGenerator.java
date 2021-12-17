package crypt.language.IRBuilder.generator;

import crypt.language.IRBuilder.generator.statement.PrintStatementGenerator;
import crypt.language.IRBuilder.generator.statement.PrintlnStatementGenerator;
import crypt.language.parser.AST.Statement;
import org.objectweb.asm.MethodVisitor;

import java.io.IOException;
import java.util.List;

public class StatementGenerator implements Statement.Visitor<Void>{
    public StatementGenerator(MethodVisitor methodVisitor){
        this.methodVisitor = methodVisitor;
    }

    private MethodVisitor methodVisitor;
    ExpressionGenerator expressionGenerator = new ExpressionGenerator(methodVisitor);


    public void generate(List<Statement> statements){ statements.forEach(this::visit); }

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
        //if(statement instanceof Statement.Input) return visitInputStatement((Statement.Input) statement);
        throw new Error("Statement not found");
    }

    @Override
    public Void visitPrintStatement(Statement.Print printStatement) {
        new PrintStatementGenerator(expressionGenerator, methodVisitor).generate(printStatement);
        return null;
    }

    @Override
    public Void visitPrintlnStatement(Statement.Println printlnStatement) {
        new PrintlnStatementGenerator(expressionGenerator, methodVisitor).generate(printlnStatement);
        return null;
    }

    @Override
    public Void visitExpressionStatement(Statement.ExpressionStatement expressionStatement) {
        return null;
    }

    @Override
    public Void visitVariableDeclaration(Statement.Variable statement) {
        return null;
    }

    @Override
    public Void visitBlockStatement(Statement.Block statement) {
        return null;
    }

    @Override
    public Void visitIfStatement(Statement.If statement) {
        return null;
    }

    @Override
    public Void visitWhileStatement(Statement.While statement) {
        return null;
    }

    @Override
    public Void visitFunctionDeclaration(Statement.Function statement) {
        return null;
    }

    @Override
    public Void visitReturnStatement(Statement.Return statement) {
        return null;
    }

    @Override
    public Void visitClassDeclaration(Statement.Class statement) {
        return null;
    }

    @Override
    public Void visitInputStatement(Statement.Input statement) throws IOException {
        return null;
    }
}
