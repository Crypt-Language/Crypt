import dev.aurumbyte.crypt.CryptCompiler.Lexer.CryptLexer;
import dev.aurumbyte.crypt.CryptCompiler.Lexer.token.Token;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LexerTest {
    @Test
    public void lexerTest() throws Exception {
        CryptLexer lexer = new CryptLexer("println \"Hello\";\n    println \"Hello indent.\"");
        List<Token> tokens = lexer.lex();
        tokens.forEach(System.out::println);
    }
}
