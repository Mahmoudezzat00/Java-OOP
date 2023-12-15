package tests;

import utest.*;

import flow.*;
import node.base.*;

public class WireTest extends Testable {
    private final int testInput = 1;
    private final int testOutput = 2;
    
    public void assertion() {
        Wire w = new Wire();

        check("Wire constructor: initial value of bit is not ZERO.", w.getBit() == Bit.ZERO);
        check("Wire constructor: initial value of end is not null.", w.getEnd() == null);

        w.setBit(Bit.ONE);
        check("Wire.setBit(): new value of bit is not set.", w.getBit() == Bit.ONE);

        DummySender s = new DummySender();
        DummyReceiver r = new DummyReceiver();
        
        Wire.connect(s, testOutput, r, testInput);

        check("Wire.connect(): does not connect the sender and the receiver with the sender's wire.", s.wire == r.wire);
        check("Wire.connect(): the receiver does not get updated.", r.updated);

        check("Wire.getEnd(): does not return the receiver.", s.wire.getEnd() == r);        

        r.updated = false;
        s.wire.setBit(Bit.ZERO);
        check("Wire.setBit(): the receiver gets updated when the bit is not changed.", !r.updated);

        s.wire.setBit(Bit.ONE);
        check("Wire.setBit(): the receiver does not get updated when the bit changes.", r.updated);
    }

    private class DummySender implements Sender {
        public Wire wire = new Wire();

        @Override
        public Wire getOutput(int index) {
            if (index != testOutput)
                check("Wire.connect(): gets the output with wrong index from the sender.", false);
            return wire;
        }
    }

    private class DummyReceiver implements Receiver {
        public Wire wire;
        public boolean updated;

        @Override
        public void setInput(int index, Wire input) {
            if (index != testInput)
                check("Wire.connect(): sets the input of the receiver with wrong index.", false);
            wire = input;
        }

        @Override
        public void update() {
            updated = true;
        }
    }

    public String description() { return "WireTest"; }
    public String className() { return "flow.Wire"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className())
            , staticMethod(className() + ".connect", new Class[] { Sender.class, Integer.TYPE, Receiver.class, Integer.TYPE })
            , method(className() + ".getBit")
            , method(className() + ".setBit", Bit.class)
            , method(className() + ".getEnd")
            };
    }

    public static void main(String... args) {
        Test.main(new WireTest());
    }
}
