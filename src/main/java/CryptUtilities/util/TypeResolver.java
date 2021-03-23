package CryptUtilities.util;

import CryptCompiler.IRBuilder.types.BuiltInTypes;
import CryptCompiler.IRBuilder.types.ClassType;
import CryptCompiler.node.interfaces.Type;
import gen.CryptParser;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;
import com.google.common.primitives.Ints;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Optional;

public class TypeResolver {

    public static Type getFromTypeContext(CryptParser.TypeContext typeContext) {
        if(typeContext == null) return BuiltInTypes.VOID;
        return getFromTypeName(typeContext.getText());
    }

    public static Type getFromTypeName(String typeName) {
        if(typeName.equals("java.lang.String")) return BuiltInTypes.STRING;
        Optional<? extends Type> builtInType = getBuiltInType(typeName);
        if(builtInType.isPresent()) return builtInType.get();
        return new ClassType(typeName);
    }

    public static Type getFromValue(@NotNull CryptParser.ValueContext value) {
        String stringValue = value.getText();
        if (StringUtils.isEmpty(stringValue)) return BuiltInTypes.VOID;
        if (value.INT() != null) {
            if (Ints.tryParse(stringValue) != null) {
                return BuiltInTypes.INT;
            }
        } else if (value.F_BOOLEAN() != null) {
            return BuiltInTypes.BOOLEAN;
        } else if (value.F_DECIMAL() != null){
            if (Floats.tryParse(stringValue) != null) {
                return BuiltInTypes.FLOAT;
            } else if (Doubles.tryParse(stringValue) != null) {
                return BuiltInTypes.DOUBLE;
            }
        }
        return BuiltInTypes.STRING;
    }

    public static Type getFromExpression(@NotNull CryptParser.ExpressionContext expression) {
        String stringValue = expression.getText();
        if (StringUtils.isEmpty(stringValue)) return BuiltInTypes.VOID;

        if (StringUtils.startsWith(stringValue, "\"")) {
            return BuiltInTypes.STRING;
        } else if (Ints.tryParse(stringValue) != null){
            return BuiltInTypes.INT;
        } else {
            throw new UnsupportedOperationException("Type unrecognizable");
        }
    }

    public static Object getValueFromString(String stringValue, Type type) {
        if (TypeChecker.isInt(type)) {
            return Integer.valueOf(stringValue);
        }
        if (TypeChecker.isFloat(type)) {
            return Float.valueOf(stringValue);
        }
        if (TypeChecker.isDouble(type)) {
            return Double.valueOf(stringValue);
        }
        if (TypeChecker.isBool(type)) {
            return Boolean.valueOf(stringValue);
        }
        if (type == BuiltInTypes.STRING) {
            stringValue = StringUtils.removeStart(stringValue, "\"");
            stringValue = StringUtils.removeEnd(stringValue, "\"");
            return stringValue;
        }
        throw new AssertionError("Objects not yet implemented!");
    }

    private static Optional<BuiltInTypes> getBuiltInType(String typeName) {
        return Arrays.stream(BuiltInTypes.values())
                .filter(type -> type.getName().equals(typeName))
                .findFirst();
    }
}
