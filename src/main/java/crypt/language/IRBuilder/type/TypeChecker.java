package crypt.language.IRBuilder.type;

public final class TypeChecker {
    public static boolean isInt(Type type) {
        return type == Types.INT;
    }

    public static boolean isBool(Type type) {
        return type == Types.BOOLEAN;
    }

    public static boolean isFloat(Type type) {
        return type == Types.FLOAT;
    }

    public static boolean isDouble(Type type) {
        return type == Types.DOUBLE;
    }
}
