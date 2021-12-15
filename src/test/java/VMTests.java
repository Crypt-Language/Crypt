import crypt.language.vm.CryptVM;
import org.junit.Test;

import static crypt.language.vm.bytecode.CryptIR.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VMTests {
    @Test
    public void testEmptyProgramDoesNothing() throws Exception {
        CryptVM vm = new CryptVM(HALT);
        vm.step();
        assertEquals(1, vm.getInstructionAddress());
        assertTrue(vm.isHalted());
        assertTrue(vm.getStack().isEmpty());
    }

    @Test
    public void testPushPushAndThenHalt() throws Exception {
        CryptVM CryptVM = new CryptVM(PUSH, (byte) 42, PUSH, (byte)68, HALT);
        CryptVM.run();
        assertEquals(5, CryptVM.getInstructionAddress());
        assertTrue(CryptVM.isHalted());
        //assertStackContains(CryptVM, 68, 42);
    }

    @Test
    public void testAddTwoNumbers() throws Exception {
        CryptVM CryptVM = new CryptVM(PUSH, (byte)1, PUSH, (byte)2, ADD, HALT);
        CryptVM.run();
        assertEquals(6, CryptVM.getInstructionAddress());
        assertTrue(CryptVM.isHalted());
        //assertStackContains(CryptVM, 3);
    }

    @Test
    public void testUnaryNotTrue() {
        CryptVM CryptVM = new CryptVM(PUSH, (byte)1, NOT, HALT);
        //assertProgramRunsToHaltAndInstructionAddressIs(CryptVM, 4);
        //assertStackContains(CryptVM, 0);
    }

    @Test
    public void testUnaryNotFalse() {
        CryptVM CryptVM = new CryptVM(PUSH, (byte) 0, NOT, HALT);
        //assertProgramRunsToHaltAndInstructionAddressIs(CryptVM, 4);
        //assertStackContains(CryptVM, 1);
    }

    @Test(expected = Exception.class)
    public void testNotNeedsOneItemOnTheStack() throws Exception {
        CryptVM CryptVM = new CryptVM(NOT, HALT);
        CryptVM.run();
    }

    @Test
    public void testAndTrueTrue() {
        CryptVM CryptVM = new CryptVM(PUSH, (byte)1, PUSH, (byte)1, AND, HALT);
        //assertProgramRunsToHaltAndInstructionAddressIs(CryptVM, 6);
        //assertStackContains(CryptVM, 1);
    }

    @Test(expected = Exception.class)
    public void testAndNeedsTwoItemsOnTheStack() throws Exception {
        CryptVM CryptVM = new CryptVM(AND, HALT);
        CryptVM.run();
    }

    @Test
    public void testOrTrueFalse() {
        CryptVM CryptVM = new CryptVM(PUSH, (byte)1, PUSH, (byte)0, OR, HALT);
        //assertProgramRunsToHaltAndInstructionAddressIs(CryptVM, 6);
        //assertStackContains(CryptVM, 1);
    }

    @Test(expected = Exception.class)
    public void testOrNeedsTwoItemsOnTheStack() throws Exception {
        CryptVM CryptVM = new CryptVM(OR, HALT);
        CryptVM.run();
    }

    @Test
    public void testPop() {
        CryptVM CryptVM = new CryptVM(PUSH, (byte)42, POP, HALT);
        //assertProgramRunsToHaltAndInstructionAddressIs(CryptVM, 4);
        //assertStackIsEmpty(CryptVM);
    }

    @Test(expected = Exception.class)
    public void testPopNeedsAnItemOnTheStack() throws Exception {
        CryptVM CryptVM = new CryptVM(POP);
        CryptVM.step();
    }

    @Test
    public void testDup() {
        CryptVM CryptVM = new CryptVM(PUSH, (byte)42, DUP, HALT);
        //assertProgramRunsToHaltAndInstructionAddressIs(CryptVM, 4);
        //assertStackContains(CryptVM, 42, 42);
    }

    @Test(expected = Exception.class)
    public void testDupNeedsAnItemOnTheStack() throws Exception {
        CryptVM CryptVM = new CryptVM(DUP);
        CryptVM.step();
    }
}
