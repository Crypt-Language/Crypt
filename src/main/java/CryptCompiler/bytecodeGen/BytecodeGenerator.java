package CryptCompiler.bytecodeGen;

import CryptCompiler.node.file.FileUnit;

public class BytecodeGenerator {
    private final FileUnit fileUnit;
    private final String fileName;

    public BytecodeGenerator(String fileName, FileUnit fileUnit){
        this.fileName = fileName;
        this.fileUnit = fileUnit;
    }

    public byte[] generateBytecode(){
        FileBytecodeGenerator fileBytecodeGenerator = new FileBytecodeGenerator();
        return fileBytecodeGenerator.generate(fileName, fileUnit).toByteArray();
    }
}
