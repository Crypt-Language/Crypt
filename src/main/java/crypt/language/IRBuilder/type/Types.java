package crypt.language.IRBuilder.type;

public enum Types implements Type{

    BOOLEAN("bool",boolean.class,"Z", TypeOpcodes.INT),
    INT("int", int.class,"I", TypeOpcodes.INT),
    CHAR ("char", char.class,"C", TypeOpcodes.INT),
    BYTE ("byte", byte.class,"B", TypeOpcodes.INT),
    SHORT ("short", short.class,"S", TypeOpcodes.INT),
    LONG ("long", long.class,"J", TypeOpcodes.LONG),
    FLOAT ("float", float.class,"F", TypeOpcodes.FLOAT),
    DOUBLE ("double", double.class,"D", TypeOpcodes.DOUBLE),
    STRING ("str", String.class,"Ljava/lang/String;", TypeOpcodes.OBJECT),
    BOOLEAN_ARR("bool[]",boolean[].class,"[B", TypeOpcodes.OBJECT),
    INT_ARR ("int[]", int[].class,"[I", TypeOpcodes.OBJECT),
    CHAR_ARR ("char[]", char[].class,"[C", TypeOpcodes.OBJECT),
    BYTE_ARR ("byte[]", byte[].class,"[B", TypeOpcodes.OBJECT),
    SHORT_ARR ("short[]", short[].class,"[S", TypeOpcodes.OBJECT),
    LONG_ARR ("long[]", long[].class,"[J", TypeOpcodes.OBJECT),
    FLOAT_ARR ("float[]", float[].class,"[F", TypeOpcodes.OBJECT),
    DOUBLE_ARR ("double[]", double[].class,"[D", TypeOpcodes.OBJECT),
    STRING_ARR ("str[]", String[].class,"[Ljava/lang/String;", TypeOpcodes.OBJECT),
    NONE("", null,"", TypeOpcodes.OBJECT),
    VOID("void", void.class,"V", TypeOpcodes.VOID);

    private final String name;
    private final Class<?> typeClass;
    private final String descriptor;
    private final TypeOpcodes opcodes;


    Types(String name, Class<?> typeClass, String descriptor, TypeOpcodes opcodes) {
        this.name = name;
        this.typeClass = typeClass;
        this.descriptor = descriptor;
        this.opcodes = opcodes;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class<?> getTypeClass() {
        return typeClass;
    }

    @Override
    public String getDescriptor() {
        return descriptor;
    }

    @Override
    public String getInternalName() {
        return getDescriptor();
    }

    @Override
    public int getLoadVariableOpcode() {
        return opcodes.getLoad();
    }

    @Override
    public int getStoreVariableOpcode() {
        return opcodes.getStore();
    }

    @Override
    public int getReturnOpcode() {
        return opcodes.getReturn();
    }

    @Override
    public int getAddOpcode() {
        return opcodes.getAdd();
    }

    @Override
    public int getSubtractOpcode() {
        return  opcodes.getSubtract();
    }

    @Override
    public int getMultiplyOpcode() {
        return opcodes.getMultiply();
    }

    @Override
    public int getDivideOpcode() {
        return opcodes.getDivide();
    }
}
