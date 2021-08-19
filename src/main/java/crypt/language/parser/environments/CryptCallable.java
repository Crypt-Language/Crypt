package crypt.language.parser.environments;

import crypt.language.CryptInterpreter;

import java.util.List;

public interface CryptCallable {
    int arity();
    Object call(CryptInterpreter interpreter, List<Object> arguments);
}
