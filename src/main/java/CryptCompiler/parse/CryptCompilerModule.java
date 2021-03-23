package CryptCompiler.parse;

import CryptCompiler.IRBuilder.FileBuilder;
import CryptCompiler.node.file.FileUnit;
import CryptUtilities.gen.CryptLexer;
import CryptUtilities.gen.CryptParser;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Paths;

public class CryptCompilerModule {
    public FileUnit getFileUnit(String fileAbsolutePath, String fileName) throws IOException {
        CharStream charStream = CharStreams.fromPath(Paths.get(fileAbsolutePath));

        ANTLRErrorListener errorListener = new CryptErrListener();
        CryptLexer lexer = new CryptLexer(charStream);
        lexer.addErrorListener(errorListener);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CryptParser parser = new CryptParser(tokenStream);

        FileBuilder fileBuilder = new FileBuilder(fileName);
        return parser.fileUnit().accept(fileBuilder);
    }
}
