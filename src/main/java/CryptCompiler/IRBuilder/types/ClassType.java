package CryptCompiler.IRBuilder.types;

import CryptCompiler.node.interfaces.Type;
import com.google.common.collect.ImmutableMap;
import org.objectweb.asm.Opcodes;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class ClassType implements Type {
    private final String name;

    private static final Map<String, String> shortcuts = ImmutableMap.of(
            "List", "java.util.ArrayList"
    );

    public ClassType(String name) {
        this.name = Optional.ofNullable(shortcuts.get(name)).orElse(name);
    }

    public static ClassType integer_type() {
        return new ClassType("java.lang.Integer");
    }

    public static ClassType double_type() {
        return new ClassType("java.lang.Double");
    }

    public static ClassType boolean_type() {
        return new ClassType("java.lang.Boolean");
    }

    public static ClassType float_type() {
        return new ClassType("java.lang.Float");
    }

    public static Type string_type() {
        return new ClassType("java.lang.String");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class<?> getTypeClass() {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String getDescriptor() {
        return  "L" + getInternalName() + ";";
    }

    @Override
    public String getInternalName() {
        return  name.replace(".", "/");
    }

    @Override
    public int getLoadVariableOpcode() {
        return Opcodes.ALOAD;
    }

    @Override
    public int getStoreVariableOpcode() {
        return Opcodes.ASTORE;
    }

    @Override
    public int getReturnOpcode() {
        return Opcodes.ARETURN;
    }

    @Override
    public int getAddOpcode() {
        throw new RuntimeException("Addition operation not (yet ;) ) supported for custom objects");
    }

    @Override
    public int getSubtractOpcode() {
        throw new RuntimeException("Subtraction operation not (yet ;) ) supported for custom objects");
    }

    @Override
    public int getMultiplyOpcode() {
        throw new RuntimeException("Multiplication operation not (yet (^_^)) supported for custom objects");
    }

    @Override
    public int getDivideOpcode() {
        throw new RuntimeException("Division operation not (yet ;) ) supported for custom objects");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassType classType = (ClassType) o;

        return Objects.equals(name, classType.name);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
