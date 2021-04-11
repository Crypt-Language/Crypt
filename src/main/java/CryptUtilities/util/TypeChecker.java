package CryptUtilities.util;

import CryptCompiler.IRBuilder.types.BuiltInTypes;
import CryptCompiler.node.interfaces.Type;

public final class TypeChecker {
    public static boolean isInt(Type type) {
        return type == BuiltInTypes.INT;
    }

    public static boolean isBool(Type type) {
        return type == BuiltInTypes.BOOLEAN;
    }

    public static boolean isFloat(Type type) {
        return type == BuiltInTypes.FLOAT;
    }

    public static boolean isDouble(Type type) {
        return type == BuiltInTypes.DOUBLE;
    }
}
