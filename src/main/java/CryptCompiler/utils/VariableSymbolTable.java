package CryptCompiler.utils;

import CryptCompiler.Lexer.token.Token;

import java.util.HashMap;
import java.util.Map;

public class VariableSymbolTable {
    private final VariableSymbolTable enclosing;
    private final Map<String, Object> values = new HashMap<>();

    public VariableSymbolTable() {
        enclosing = null;
    }

    VariableSymbolTable(VariableSymbolTable enclosing) {
        this.enclosing = enclosing;
    }

    Object get(Token name) {
        if (values.containsKey(name.lexeme)) {
            return values.get(name.lexeme);
        }


        if (enclosing != null) return enclosing.get(name);

        throw new Error("Undefined variable '" + name.literal + "'.");
    }

    void define(String name, Object value) {
        values.put(name, value);
    }

    void assign(Token name, Object value) {
        if (values.containsKey(name.lexeme)) {
            values.put((String) name.lexeme, value);
            return;
        }

        if (enclosing != null) {
            enclosing.assign(name, value);
            return;
        }

        throw new Error("Undefined variable '" + name.literal + "'.");
    }
}
