package tests;

import utest.*;

import flow.Bit;

public class BitTest extends Testable {
    public void assertion() {
        Bit zero = Bit.ZERO;
        Bit one = Bit.ONE;

        check("Bit.invert(): inverse of ZERO is not ONE.", zero.invert() == Bit.ONE);
        check("Bit.invert(): inverse of ONE is not ZERO.", one.invert() == Bit.ZERO);
    }

    public String description() { return "BitTest"; }
    public String className() { return "flow.Bit"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { method(className() + ".values")
            , staticMethod(className() + ".valueOf", String.class)
            , staticMethod(className() + ".valueOf", new Class[] { Class.class, String.class })
            , method(className() + ".name")
            , method(className() + ".equals", Object.class)
            , method(className() + ".toString")
            , method(className() + ".hashCode")
            , method(className() + ".compareTo", Object.class)
            , method(className() + ".compareTo", Enum.class)
            , method(className() + ".getDeclaringClass")
            , method(className() + ".ordinal")
            , method(className() + ".invert")
            };
    }

    public Object[] expectedFields() throws Exception {
        return new Object[]
            { staticField(className() + ".ZERO")
            , staticField(className() + ".ONE")
            };
    }

    public static void main(String... args) {
        Test.main(new BitTest());
    }
}
