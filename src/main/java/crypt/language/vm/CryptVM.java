package crypt.language.vm;

import java.util.Collection;
import java.util.Stack;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static crypt.language.vm.bytecode.CryptIR.*;

public class CryptVM {
    private final byte[] program;
    private byte instructionAddress = 0;
    private final Stack<Byte> stack = new Stack<>();
    private boolean halted = false;

    public CryptVM(byte... instructions) {
        checkArgument(instructions.length > 0, "A program should have at least an instruction");
        this.program = instructions;
    }

    public int getInstructionAddress() {
        return instructionAddress;
    }

    public Collection<Byte> getStack() {
        return stack;
    }

    public boolean isHalted() {
        return halted;
    }

    public void run() throws Exception {
        while (!halted) {
            step();
        }
    }

    public void step() throws Exception {
        checkState(!halted, "An halted CPU cannot execute the program");
        byte nextInstruction = getNextWordFromProgram("Should have a next instruction");
        decodeInstruction(nextInstruction);
    }

    private void decodeInstruction(byte instruction) throws Exception {
        switch (instruction) {
            default -> throw new Exception("Unknown instruction: " + instruction);
            case NOT -> {
                checkStackHasAtLeastOneItem("NOT");
                stack.push(toInt(!toBool(stack.pop())));
                break;
            }
            case ADD, SUB, MUL, DIV, AND, OR -> {
                if (stack.size() < 2) {
                    throw new Exception("There should be at least two items on the stack to execute a binary instruction");
                }
                byte n2 = stack.pop();
                byte n1 = stack.pop();
                stack.push(doBinaryOp(instruction, n1, n2));
                break;
            }
            case HALT -> this.halted = true;
            case PUSH -> {
                // The word after the instruction will contain the value to push
                byte value = getNextWordFromProgram("Should have the value after the PUSH instruction");
                stack.push(value);
                break;
            }

            case POP -> {
                checkStackHasAtLeastOneItem("POP");
                stack.pop();
            }

            case DUP -> {
                checkStackHasAtLeastOneItem("DUP");
                byte n = stack.peek();
                stack.push(n);
            }
        }
    }

    private byte getNextWordFromProgram(String errorMessage) throws Exception {
        if (instructionAddress >= program.length) {
            throw new Exception(errorMessage);
        }
        byte nextWord = program[instructionAddress];
        ++instructionAddress;
        return nextWord;
    }

    private void checkStackHasAtLeastOneItem(String instruction) throws Exception {
        if (stack.size() < 1) {
            throw new Exception("There should be at least one item on the stack to execute an " + instruction + " instruction");
        }
    }

    private Byte doBinaryOp(byte instruction, byte n1, byte n2) {
        return switch (instruction) {
            case ADD -> (byte) (n1 + n2);
            case SUB -> (byte) (n1 - n2);
            case MUL -> (byte) (n1 * n2);
            case DIV -> (byte) (n1 / n2);
            case AND -> toInt(toBool(n1) && toBool(n2));
            case OR -> toInt(toBool(n1) || toBool(n2));
            default -> throw new AssertionError();
        };
    }

    private boolean toBool(int n) {
        return n != 0;
    }

    private byte toInt(boolean b) {
        return (byte) (b ? 1 : 0);
    }
}
