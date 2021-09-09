package crypt.language.IRBuilder.type;

import java.util.HashMap;
import java.util.Map;

public class DescriptorFactory {
    public static Map<Type, String> typeDescriptors = new HashMap<>();
    public static String getDescriptor(Type type){
        return typeDescriptors.get(type);
    }

    static {
        typeDescriptors.put(Types.INT, "I");
        typeDescriptors.put(Types.STRING, "Ljava/lang/String;");
        typeDescriptors.put(Types.FLOAT, "F");
        typeDescriptors.put(Types.DOUBLE, "D");
    }
}
