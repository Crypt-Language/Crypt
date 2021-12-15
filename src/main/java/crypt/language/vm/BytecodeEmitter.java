package crypt.language.vm;

import crypt.language.parser.AST.Statement;
import crypt.language.vm.bytecode.CryptIR;
import java.util.List;

public class BytecodeEmitter {
    private static int index = 0;
    public static byte[] bytecode;

    public static byte[] emitBytecode(List<Statement> statements){

        emit(CryptIR.HALT);
        return bytecode;
    }

    private static void emit(byte IR){
        bytecode[index] = IR;
        index++;
    }

    private void emit(byte... IR){
        for (byte code : IR) {
            bytecode[index] = code;
            index++;
        }
    }
}
