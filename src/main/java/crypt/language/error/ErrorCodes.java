package crypt.language.error;

import java.util.HashMap;
import java.util.Map;

public class ErrorCodes {
    public static Map<Integer, String> errorMessages = new HashMap<>();
    public static Object where;
    public static int line = 0;

    static {
        errorMessages.put(1, "Invalid symbol " + where + "at line " + line);
        errorMessages.put(2, "Invalid token " + where);
    }
}
