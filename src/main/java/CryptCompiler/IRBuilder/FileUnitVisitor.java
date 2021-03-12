package CryptCompiler.IRBuilder;

import CryptCompiler.node.file.FileUnit;
import CryptCompiler.node.interfaces.Statement;
import gen.CryptParser;
import gen.CryptParserBaseVisitor;

import java.util.List;
import java.util.stream.Collectors;

public class FileUnitVisitor extends CryptParserBaseVisitor<FileUnit> {
    public FileUnit visitFileUnit(CryptParser.FileUnitContext ctx){
        List<Statement> statements = ctx.fileBody().statement()
                .stream()
                .map(statementContext -> statementContext.accept())
                .collect(Collectors.toList());

        return new FileUnit(statements);
    }
}
