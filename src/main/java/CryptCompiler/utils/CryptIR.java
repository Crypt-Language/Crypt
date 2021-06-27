package CryptCompiler.utils;

public enum CryptIR {
    EOF,

    ADD, MUL, DIV, SUB, IFGT, IFEQ, IFLT, IFGE, IFLE,

    LOAD, STORE,

    PRINT, PRINTLN
}
