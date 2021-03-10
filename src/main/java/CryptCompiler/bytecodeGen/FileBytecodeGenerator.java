package CryptCompiler.bytecodeGen;

import CryptCompiler.node.file.FileUnit;
import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class FileBytecodeGenerator {
    private final ClassWriter classWriter;

    public FileBytecodeGenerator(){
        classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
    }

    public ClassWriter generate(String fileName, FileUnit fileUnit){
        String name = StringUtils.remove(fileName, ".crypt");
        classWriter.visit(52, Opcodes.ACC_PUBLIC, name, null, "java/lang/Object", null);

        //Main method will be auto generated now
        MethodVisitor mv = classWriter.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mv.visitCode();

        /*
        List<Void> functions = fileUnit.getFunctions();
        Collection<Void> fields = fileUnit.getFields();

        functions.forEach(function -> function.accept(FunctionBuilder));
        fields.forEach(field -> field.accept(FieldBuilder));
        */

        return classWriter;
    }
}
