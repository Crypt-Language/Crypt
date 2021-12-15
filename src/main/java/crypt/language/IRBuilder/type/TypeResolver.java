package crypt.language.IRBuilder.type;

import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;
import com.google.common.primitives.Ints;
import crypt.language.parser.AST.Expression;

import java.util.Arrays;
import java.util.Optional;

public class TypeResolver {
    //public static Type getFromTypeContext(CylvreParser.TypeContext typeContext) {
    //    if(typeContext == null) return Types.VOID;
    //    return getFromTypeName(typeContext.getText());
    //}

    public static Type getFromTypeName(String typeName) {
        if(typeName.equals("java.lang.String")) return Types.STRING;
        Optional<? extends Type> Types = getTypes(typeName);
        if(Types.isPresent()) return Types.get();
        //return new ClassType(typeName);
        return null;
    }

    public static Type getFromValue(Expression.Literal value) {
        Object finalValue = value.value;
        if (finalValue.toString().isEmpty()) return Types.VOID;
        if (finalValue != null) {
            if (Ints.tryParse(finalValue.toString()) != null) {
                return Types.INT;
            } else if (Floats.tryParse(finalValue.toString()) != null) {
                return Types.FLOAT;
            } else if (Doubles.tryParse(finalValue.toString()) != null) {
                return Types.DOUBLE;
            }
        } else if (finalValue == boolean.class) {
            return Types.BOOLEAN;
        }
        return Types.STRING;
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
        if (type == Types.STRING) {
            //stringValue = stringValue.removeStart(stringValue, "\"");
            //stringValue = //stringValue.removeEnd("\"");
            return stringValue;
        }
        throw new AssertionError("Objects not yet implemented!");
    }

    private static Optional<Types> getTypes(String typeName) {
        return Arrays.stream(Types.values())
                .filter(type -> type.getName().equals(typeName))
                .findFirst();
    }
}
