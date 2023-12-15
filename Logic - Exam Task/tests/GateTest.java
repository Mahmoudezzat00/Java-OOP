package tests;

import utest.*;

import flow.*;
import node.base.*;
import exception.*;

public class GateTest extends Testable {
    private final int numInputs = 2;
    private final int numOutputs = 3;
    
    public void assertion() {
        boolean ok = true;
        try {
            new DummyGate(-1, numOutputs);
            ok = false;
        } catch (LogicException e) {
            check("Gate constructor: throws an exception with wrong message.", ("Invalid number of inputs: -1").equals(e.getMessage()));
        } catch (Throwable e) {
            check("Gate constructor: throws wrong type of exception instead of LogicException.", false);
        }
        check("Gate constructor: does not throw exception when the number of inputs is a negative number.", ok);

        try {
            new DummyGate(numInputs, -2);
            ok = false;
        } catch (LogicException e) {
            check("Gate constructor: throws an exception with wrong message.", ("Invalid number of outputs: -2").equals(e.getMessage()));
        } catch (Throwable e) {
            check("Gate constructor: throws wrong type of exception instead of LogicException.", false);
        }
        check("Gate constructor: does not throw exception when the number of outputs is a negative number.", ok);

        Gate gate = new DummyGate(numInputs, numOutputs);

        Wire input1 = new Wire();
        Wire input2 = new Wire();

        try {
            gate.getOutput(-1);
            ok = false;
        } catch (LogicException e) {
            check("Gate.getOutput(): throws an exception with wrong message when the argument is a negative number.", ("Invalid index: -1").equals(e.getMessage()));
        } catch (Throwable e) {
            check("Gate.getOutput(): throws wrong type of exception instead of LogicException when the argument is a negative number.", false);
        }
        check("Gate.getOutput(): does not throw exception when the index is a negative number.", ok);

        try {
            gate.getOutput(numOutputs);
            ok = false;
        } catch (LogicException e) {
            check("Gate.getOutput(): throws an exception with wrong message when the argument is the number of outputs.", ("Invalid index: " + numOutputs).equals(e.getMessage()));
        } catch (Throwable e) {
            check("Gate.getOutput(): throws wrong type of exception instead of LogicException the argument is the number of outputs.", false);
        }
        check("Gate.getOutput(): does not throw exception when the index equals the number of outputs.", ok);

        try {
            gate.getOutput(numOutputs + 2);
            ok = false;
        } catch (LogicException e) {
            check("Gate.getOutput(): throws an exception with wrong message when the argument is greater than the number of outputs.", ("Invalid index: " + (numOutputs + 2)).equals(e.getMessage()));
        } catch (Throwable e) {
            check("Gate.getOutput(): throws wrong type of exception instead of LogicException when the argument is greater than the number of outputs.", false);
        }
        check("Gate.getOutput(): does not throw exception when the argument is greater than the number of outputs.", ok);

        for (int i = 0; i < numOutputs; i++)
            check("Gate.getOutput(): output " + i + " is null.", gate.getOutput(i) != null);

        try {
            gate.setInput(-1, input1);
            ok = false;
        } catch (LogicException e) {
            check("Gate.setInput(): throws an exception with wrong message when the index is a negative number.", "Invalid index: -1".equals(e.getMessage()));
        } catch (Throwable e) {
            check("Gate.setInput(): throws wrong type of exception instead of LogicException when the index is a negative number.", false);
        }
        check("Gate.setInput(): does not throw an exception when the index is a negative number.", ok);

        try {
            gate.setInput(numInputs, input1);
            ok = false;
        } catch (LogicException e) {
            check("Gate.setInput(): throws an exception with wrong message when the index is the number of inputs.", ("Invalid index: " + numInputs).equals(e.getMessage()));
        } catch (Throwable e) {
            check("Gate.setInput(): throws wrong type of exception instead of LogicException the index is the number of inputs.", false);
        }
        check("Gate.setInput(): does not throw exception when the index equals the number of inputs.", ok);

        try {
            gate.setInput(numInputs + 3, input1);
            ok = false;
        } catch (LogicException e) {
            check("Gate.setInput(): throws an exception with wrong message when the index is greater than the number of inputs.", ("Invalid index: " + (numInputs + 3)).equals(e.getMessage()));
        } catch (Throwable e) {
            check("Gate.setInput(): throws wrong type of exception instead of LogicException when the index is greater than the number of inputs.", false);
        }
        check("Gate.setInput(): does not throw exception when the index is greater than the number of inputs.", ok);

        gate.setInput(0, input1);
        gate.setInput(1, input2);
        gate.update();

        for (int i = 0; i < numOutputs; i++) {
            check("Gate.getOutput(): output " + i + " is null. (1)", gate.getOutput(i) != null);
            check("Gate.update(): output " + i + " is incorrect. (1)", gate.getOutput(i).getBit() == Bit.ZERO);
        }

        input1.setBit(Bit.ONE);
        gate.update();

        for (int i = 0; i < numOutputs; i++) {
            check("Gate.getOutput(): output " + i + " is null. (2)", gate.getOutput(i) != null);
            check("Gate.update(): output " + i + " is incorrect. (2)", gate.getOutput(i).getBit() == Bit.ZERO);
        }

        input2.setBit(Bit.ONE);
        gate.update();

        for (int i = 0; i < numOutputs; i++) {
            check("Gate.getOutput(): output " + i + " is null. (3)", gate.getOutput(i) != null);
            check("Gate.update(): output " + i + " is incorrect. (3)", gate.getOutput(i).getBit() == Bit.ONE);
        }
    }

    private class DummyGate extends Gate {
        private DummyGate(int numInputs, int numOutputs) {
            super(numInputs, numOutputs);
        }

        @Override
        protected Bit calculateResult(Bit[] bits) {
            check("Gate.update(): passes null to calculateResult().", bits != null);
            check("Gate.update(): does not pass an array of as many elements as the number of inputs to calculateResult().", bits.length == numInputs);
            for (Bit b : bits)
                check("Gate.update(): one of the bits passed to calculateResult() is null.", b != null);
            return bits[bits.length - 1];
        }
    }

    public String description() { return "GateTest"; }
    public String className() { return "node.base.Gate"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] { Integer.TYPE, Integer.TYPE })
            , method(className() + ".setInput", new Class[] { Integer.TYPE, Wire.class })
            , method(className() + ".getOutput", Integer.TYPE)
            , method(className() + ".update")
            };
    }

    public static void main(String... args) {
        Test.main(new GateTest());
    }
}
