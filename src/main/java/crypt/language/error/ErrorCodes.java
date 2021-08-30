package crypt.language.error;

import java.util.HashMap;
import java.util.Map;

public class ErrorCodes {
    public static Map<Integer, String> errorMessages = new HashMap<>();
    public static Object where;
    public static int line = 0;
    public static String message = "";

    static {
        errorMessages.put(0, "CryptError :: line " + message);
        errorMessages.put(1, "Crypt1 :: line " + line + " Invalid symbol " + where);
        errorMessages.put(2, "Crypt2 :: line " + line + " Expecting semicolon, Found " + where);
        errorMessages.put(3, "Crypt3 :: line " + line + " Undefined variable " + where);
        errorMessages.put(4, "Crypt4 :: line " + line + " Undefined function/method " + where);
        errorMessages.put(5, "Crypt5 :: line " + line + " " + where);
    }
}
