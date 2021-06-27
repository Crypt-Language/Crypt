import CryptCompiler.Lexer.CryptLexer;
import CryptCompiler.Lexer.token.Token;
import CryptCompiler.Parser.CryptParser;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ParserTests {

    @Test
    void testParsing() throws Exception{
        CryptLexer lexer = new CryptLexer("print \"Hello\";");
        List<Token> tokens = lexer.lex();
        CryptParser parser = new CryptParser(tokens);
        parser.parse();
    }
}
