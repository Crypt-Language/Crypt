package crypt.language.vm.bytecode;

public enum CryptIR {;
    public static final byte HALT = -1;
    public static final byte PUSH = 0;
    public static final byte ADD = 1;
    public static final byte MUL = 2;
    public static final byte DIV = 3;
    public static final byte SUB = 4;
    public static final byte AND = 5;
    public static final byte OR = 6;
    public static final byte NOT = 7;
    public static final byte RET = 8;
    public static final byte DUP = 9;
    public static final byte POP = 10;
    public static final byte JUMP = 11;
    public static final byte JUMPIF = 12;
    public static final byte IFEQ = 13;
    public static final byte IFNEQ = 14;
    public static final byte IFGT = 16;
    public static final byte IFLT = 17;
    public static final byte IFGTEQ = 18;
    public static final byte IFLTEQ = 19;
    public static final byte LOAD = 20;
    public static final byte STORE = 21;
}
