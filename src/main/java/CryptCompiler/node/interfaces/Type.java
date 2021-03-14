package CryptCompiler.node.interfaces;

public interface Type {
    String getNameOf();
    Class<?> getTypeClass();
    String getDescriptor();
    String getInternalName();
    int getLoadVariableOpcode();
    int getStoreVariableOpcode();
    int getReturnOpcode();
    int getAddOpcode();
    int getSubtractOpcode();
    int getMultiplyOpcode();
    int getDivideOpcode();
}
