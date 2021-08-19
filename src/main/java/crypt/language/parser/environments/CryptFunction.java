package crypt.language.parser.environments;

import crypt.language.CryptInterpreter;
import crypt.language.parser.AST.Statement;

import java.util.List;

public record CryptFunction(Statement.Function declaration, Environment closure) implements CryptCallable {

    @Override
    public int arity() {
        return declaration.parameters.size();
    }

    @Override
    public Object call(CryptInterpreter interpreter, List<Object> arguments) {
        Environment environment = new Environment(closure);
        for (int i = 0; i < declaration.parameters.size(); i++) {
            environment.define(declaration.parameters.get(i).lexeme,
                    arguments.get(i));
        }

        try {
            interpreter.executeBlock(declaration.body, environment);
        } catch (CryptInterpreter.Return returnValue) {
            return returnValue.value;
        }

        interpreter.executeBlock(declaration.body, environment);
        return null;
    }

    @Override
    public String toString() {
        return "[fn " + declaration.name.lexeme + "]";
    }
}
