package CryptCompiler.node.expression;

import CryptCompiler.node.interfaces.Expression;
import CryptCompiler.node.interfaces.Type;

public class Value implements Expression {
    private final String value;
    private final Type type;

    public Value(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getValue() {
            return value;
        }

    @Override
    public Type getTypeOf() {
        return type;
    }
}
