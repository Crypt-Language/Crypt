package CryptCompiler.parse;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CryptErrListener extends BaseErrorListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(CryptErrListener.class);

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        String errorFormat = "So Sorry... Syntax error at line %d, char %d. Details are as follows: %n%s";
        String errorMsg = String.format(errorFormat, line, charPositionInLine, msg);
        LOGGER.error(errorMsg);
    }

}
