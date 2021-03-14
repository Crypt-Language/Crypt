package CryptCompiler;

import CryptCompiler.bytecodeGen.BytecodeGenerator;
import CryptCompiler.node.file.FileUnit;
import CryptCompiler.parse.Parser;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class CryptC {
    public File cryptFile;

    private static final Logger LOGGER = LoggerFactory.getLogger(CryptC.class);

    public static void main(String[] args){
        try {
            new CryptC().compile(args);
        } catch (Exception e){
            LOGGER.error("ERROR: " + e.getMessage());
        }
    }

    @SneakyThrows //change later
    public void compile(String[] args){
        cryptFile = new File(args[0]);

        if(!cryptFile.getAbsolutePath().endsWith(".crypt")){
            LOGGER.error("File isn't a Crypt file. Crypt files must end in .crypt extension");
        }

        String fileAbsolutePath = cryptFile.getAbsolutePath();
        LOGGER.info("Parsing Crypt file... '{}'", fileAbsolutePath);
        FileUnit fileUnit = new Parser().getFileUnit(fileAbsolutePath);
        LOGGER.info("Parsing (Success). Compiling to Bytecode...");
        BytecodeGenerator bytecodeGenerator = new BytecodeGenerator(cryptFile.getName(), fileUnit);
        byte[] bytecode = bytecodeGenerator.generateBytecode();
        LOGGER.info("Compilation (Success). Saving Bytecode...");
        OutputStream outputStream = new FileOutputStream(StringUtils.replace(cryptFile.getName(), ".crypt", ".class"));
        IOUtils.write(bytecode, outputStream);
        LOGGER.info("Compiled successfully. To run the file, execute 'java {}'", StringUtils.remove(cryptFile.getName(), ".crypt"));
    }
}

/*TODO: Patch all the holes in the compiler.*/
