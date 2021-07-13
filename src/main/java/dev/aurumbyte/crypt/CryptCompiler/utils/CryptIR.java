package dev.aurumbyte.crypt.CryptCompiler.utils;

public enum CryptIR {
    EOF,

    ADD, MUL, DIV, SUB, IFGT, IFEQ, IFLT, IFGE, IFLE, IFNE,

    LOAD, STORE,

    PRINT, PRINTLN
}
