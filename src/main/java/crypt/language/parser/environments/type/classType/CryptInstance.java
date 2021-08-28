package crypt.language.parser.environments.type.classType;

import crypt.language.error.RuntimeError;
import crypt.language.lexer.token.Token;
import crypt.language.parser.environments.type.functionType.CryptFunction;

import java.util.HashMap;
import java.util.Map;

public class CryptInstance {
    private CryptClass type;
    private final Map<String, Object> fields = new HashMap<>();

    CryptInstance(CryptClass type) {
        this.type = type;
    }

    public Object get(Token name) {
        if (fields.containsKey(name.lexeme)) {
            return fields.get(name.lexeme);
        }

        CryptFunction method = type.findMethod(name.lexeme);
        if (method != null) return method.bind(this);

        throw new RuntimeError(name, "Undefined property '" + name.lexeme + "'.");
    }

    public void set(Token name, Object value) {
        fields.put(name.lexeme, value);
    }

    @Override
    public String toString() {
        return type.name + " instance";
    }
}
