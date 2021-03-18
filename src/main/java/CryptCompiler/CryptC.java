package CryptCompiler;

import CryptCompiler.IRBuilder.FileBuilder;
import CryptCompiler.node.file.FileUnit;
import CryptCompiler.parse.CryptCompilerModule;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    public void compile(String[] args){
        cryptFile = new File(args[0]);

        if(!cryptFile.getAbsolutePath().endsWith(".crypt")){
            LOGGER.error("File isn't a Crypt file. Crypt files must end in the .crypt extension");
        }

        String fileAbsolutePath = cryptFile.getAbsolutePath();

        try {
            LOGGER.info("Compiling Crypt file '{}'. Path: '{}'", cryptFile.getName(), fileAbsolutePath);

            FileUnit fileUnit = new CryptCompilerModule().getFileUnit(fileAbsolutePath, cryptFile.getName());
            FileBuilder fileBuilder = new FileBuilder(cryptFile.getName());
            byte[] bytecode = fileBuilder.getBytecode(fileUnit);
            OutputStream outputStream = new FileOutputStream(StringUtils.replace(cryptFile.getName(), ".crypt", ".class"));
            IOUtils.write(bytecode, outputStream);

            LOGGER.info("Compiled successfully in '{} ms'. To run the file, execute 'java {}'", System.currentTimeMillis(), StringUtils.remove(cryptFile.getName(), ".crypt"));
        } catch (IOException e){
            LOGGER.error(e.getMessage());
        }
    }
}

/*TODO: Patch all the holes in the compiler.*/
