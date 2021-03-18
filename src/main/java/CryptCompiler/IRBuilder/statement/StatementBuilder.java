package CryptCompiler.IRBuilder.statement;

import CryptCompiler.node.interfaces.Statement;
import CryptUtilities.gen.CryptParser;
import CryptUtilities.gen.CryptParserBaseVisitor;
import org.objectweb.asm.MethodVisitor;

public class StatementBuilder extends CryptParserBaseVisitor<Statement>{
    private final MethodVisitor methodVisitor;

    public StatementBuilder(MethodVisitor methodVisitor){
        this.methodVisitor = methodVisitor;
    }



    @Override
    public Statement visitPrintlnStatement(CryptParser.PrintlnStatementContext ctx){
        new PrintlnBuilder(methodVisitor).visitPrintlnStatement(ctx);
        return null;
    }

    @Override
    public Statement visitPrintStatement(CryptParser.PrintStatementContext ctx){
        new PrintBuilder(methodVisitor).visitPrintStatement(ctx);
        return null;
    }
}
