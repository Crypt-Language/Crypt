import crypt.language.utils.Debug;
import org.junit.Test;

import java.io.IOException;

public class DebugTest {
    @Test
    public void lexingDebugTest() throws IOException {
        Debug.tokenTestDebug("G:/Hello.crypt", true);
    }

    @Test
    public void parsingDebugTest() throws IOException {
        Debug.parseTestDebug("println \"Hello, World!\";", false);
    }
}
