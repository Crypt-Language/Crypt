import CryptCompiler.Lexer.CryptLexer;
import CryptCompiler.Lexer.token.Token;
import CryptCompiler.Lexer.token.TokenType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LexerTests {

    @Test
    void testLexerIfPrintsCorrectTokens() throws Exception {
        CryptLexer lexer = new CryptLexer("print \"Hello,World!\";\n    println \"Hello World\";");
        List<Token> tokens = lexer.lex();
        tokens.forEach(System.out::println);
    }
}
