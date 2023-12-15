package tests;

import utest.*;

import flow.*;
import node.*;
import exception.*;

public class LedTest extends Testable {
    public void assertion() {
        Led led = new Led();

        Wire input = new Wire();

        boolean ok = true;
        try {
            led.setInput(-1, input);
            ok = false;
        } catch (LogicException e) {
            check("Led.setInput(): throws an exception with wrong message when the argument is a negative number.", ("Invalid index: -1").equals(e.getMessage()));
        } catch (Throwable e) {
            check("Led.setInput(): throws wrong type of exception instead of LogicException when the argument is a negative number.", false);
        }
        check("Led.setInput(): does not throw exception when the index is a negative number.", ok);

        try {
            led.setInput(1, input);
            ok = false;
        } catch (LogicException e) {
            check("Led.setInput(): throws an exception with wrong message when the index is greater than 0.", ("Invalid index: 1").equals(e.getMessage()));
        } catch (Throwable e) {
            check("Led.setInput(): throws wrong type of exception instead of LogicException the index is greater than 0.", false);
        }
        check("Led.setInput(): does not throw exception when the index greater than 0.", ok);

        try {
            led.setInput(0, input);
        } catch (Throwable e) {
            check("Led.setInput(): throws an exception with correct index.", false);
        }

        input.setBit(Bit.ZERO);
        led.update();
        check("Led.isOn(): led should be off when the input is ZERO. (1)", !led.isOn());

        input.setBit(Bit.ONE);
        led.update();
        check("Led.isOn(): led should be on when the input is ONE.", led.isOn());

        input.setBit(Bit.ZERO);
        led.update();
        check("Led.isOn(): led should be off when the input is ZERO. (2)", !led.isOn());
    }

    public String description() { return "LedTest"; }
    public String className() { return "node.Led"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] {})
            , method(className() + ".setInput", new Class[] { Integer.TYPE, Wire.class })
            , method(className() + ".isOn")
            , method(className() + ".update")
            };
    }

    public static void main(String... args) {
        Test.main(new LedTest());
    }
}
