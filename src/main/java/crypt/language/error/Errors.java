package crypt.language.error;

public class Errors {
    public static void report(int errorCode, String where, int line){
        ErrorCodes.where = where;
        ErrorCodes.line = line;
        System.err.println(ErrorCodes.errorMessages.get(errorCode));
    }
}
