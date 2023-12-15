package tests;

import utest.*;
import node.*;
import flow.*;
import java.util.Arrays;

public class AndTest extends Testable {
    public void assertion() {
        DummyAnd and = new DummyAnd(3);

        Bit[] bits = new Bit[] { Bit.ONE, Bit.ONE, Bit.ZERO };
        check("And.calculateResult(): returns ONE for " + Arrays.toString(bits), and.calculateResult(bits) == Bit.ZERO);

        bits[2] = Bit.ONE;
        check("And.calculateResult(): returns ZERO for " + Arrays.toString(bits), and.calculateResult(bits) == Bit.ONE);

        bits[1] = Bit.ZERO;
        check("And.calculateResult(): returns ONE for " + Arrays.toString(bits), and.calculateResult(bits) == Bit.ZERO);
    }

    private class DummyAnd extends And {
        private DummyAnd(int numInputs) {
            super(numInputs);
        }

        @Override
        public Bit calculateResult(Bit[] bits) {
            return super.calculateResult(bits);
        }
    }

    public String description() { return "AndTest"; }
    public String className() { return "node.And"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] { Integer.TYPE })
            , method(className() + ".setInput", new Class[] { Integer.TYPE, Wire.class })
            , method(className() + ".getOutput", Integer.TYPE)
            , method(className() + ".update")
            };
    }

    public static void main(String... args) {
        Test.main(new AndTest());
    }
}
