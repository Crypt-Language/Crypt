package crypt.language.parser.environments.type.functionType;

import crypt.language.CryptInterpreter;
import crypt.language.parser.AST.Statement;
import crypt.language.parser.environments.CryptCallable;
import crypt.language.parser.environments.Environment;
import crypt.language.parser.environments.type.classType.CryptInstance;

import java.util.List;

public class CryptFunction implements CryptCallable {
    private final boolean isInitializer;
    private final Environment closure;
    private final Statement.Function declaration;

    public CryptFunction(Statement.Function declaration, Environment closure, boolean isInitializer) {
        this.isInitializer = isInitializer;
        this.closure = closure;
        this.declaration = declaration;
    }

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
            if (isInitializer) return closure.getAt(0, "this");
            return returnValue.value;
        }

        if (isInitializer) return closure.getAt(0, "this");

        interpreter.executeBlock(declaration.body, environment);
        return null;
    }

    public CryptFunction bind(CryptInstance instance) {
        Environment environment = new Environment(closure);
        environment.define("this", instance);
        return new CryptFunction(declaration, environment, isInitializer);
    }

    @Override
    public String toString() {
        return "[fn " + declaration.name.lexeme + "]";
    }
}
