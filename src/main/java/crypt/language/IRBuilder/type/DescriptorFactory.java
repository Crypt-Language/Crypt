package crypt.language.IRBuilder.type;

import java.util.HashMap;
import java.util.Map;

public class DescriptorFactory {
    public static Map<Byte, String> typeDescriptors = new HashMap<>();
    public static String getDescriptor(byte type){
        return typeDescriptors.get(type);
    }

    static {
        typeDescriptors.put(TypeFactory.NULL, ""); //TODO: Add descriptors
    }
}
