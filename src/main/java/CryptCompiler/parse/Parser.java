package CryptCompiler.parse;

import CryptCompiler.node.file.FileUnit;
import gen.CryptLexer;
import gen.CryptParser;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Paths;

public class Parser {
    public FileUnit getFileUnit(String fileAbsolutePath) throws IOException {
        CharStream charStream = CharStreams.fromPath(Paths.get(fileAbsolutePath));

        ANTLRErrorListener errorListener = new CryptErrListener();

        CryptLexer lexer = new CryptLexer(charStream);
        lexer.addErrorListener(errorListener);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CryptParser parser = new CryptParser(tokenStream);

        return new FileUnit(null);
    }
}
