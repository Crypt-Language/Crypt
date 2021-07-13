package dev.aurumbyte.crypt.CryptCompiler.utils;

import dev.aurumbyte.crypt.CryptCompiler.Lexer.token.Token;

public class RuntimeError extends RuntimeException {
    final Token token;

    public RuntimeError(Token token, String message) {
        super(message);
        this.token = token;
    }
}