package CryptCompiler.parse;

import CryptCompiler.node.file.FileUnit;
import CryptCompiler.parse.antlr.gen.CryptLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Paths;

public class Parser {
    public FileUnit getFileUnit(String fileAbsolutePath) throws IOException {
        CharStream charStream = CharStreams.fromPath(Paths.get(fileAbsolutePath));

        CryptLexer lexer = new CryptLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        //CryptParser parser = new CryptParser(tokenStream);
        return new FileUnit(null, null);
    }
}
