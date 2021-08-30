package crypt.language.IRBuilder.type;

import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;
import com.google.common.primitives.Ints;
import crypt.language.parser.AST.Expression;

public class TypeFactory {
    public static final byte NULL = 0;
    public static final byte STRING = 1;
    public static final byte INT = 2;
    public static final byte FLOAT = 3;
    public static final byte DOUBLE = 4;

    public static byte getType(Expression expression){
        if(expression instanceof Expression.Literal) {
            if (Ints.tryParse(String.valueOf(expression)) != null) return INT;
            if (Floats.tryParse(String.valueOf(expression)) != null) return FLOAT;
            if (Doubles.tryParse(String.valueOf(expression)) != null) return DOUBLE;
        }
        return NULL;
    }
}
