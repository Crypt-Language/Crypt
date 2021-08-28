package crypt.language.parser.environments.type.classType;

import crypt.language.CryptInterpreter;
import crypt.language.parser.environments.CryptCallable;
import crypt.language.parser.environments.type.functionType.CryptFunction;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CryptClass implements CryptCallable {
    public final String name;
    public CryptClass superClass;
    private Map<String, CryptFunction> methods;

    public CryptClass(String name, CryptClass superClass, Map<String, CryptFunction> methods) {
        this.name = name;
        this.methods = methods;
        this.superClass = superClass;
    }

    public CryptClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int arity() {
        CryptFunction initializer = findMethod("init");
        if (initializer == null) return 0;
        return initializer.arity();
    }

    @Override
    public Object call(CryptInterpreter interpreter, List<Object> arguments) throws IOException {
        CryptInstance instance = new CryptInstance(this);
        CryptFunction initializer = findMethod("init");
        if (initializer != null) {
            initializer.bind(instance).call(interpreter, arguments);
        }
        return instance;
    }

    public CryptFunction findMethod(String name) {
        if (methods.containsKey(name)) {
            return methods.get(name);
        }

        if (superClass != null) {
            return superClass.findMethod(name);
        }

        return null;
    }
}
