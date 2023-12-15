package tests;

import utest.*;

import flow.*;
import node.*;
import exception.*;

public class SourceTest extends Testable {
    public void assertion() {
        Source source = new Source();

        boolean ok = true;
        try {
            source.getOutput(-1);
            ok = false;
        } catch (LogicException e) {
            check("Source.getOutput(): throws an exception with wrong message when the argument is a negative number.", ("Invalid index: -1").equals(e.getMessage()));
        } catch (Throwable e) {
            check("Source.getOutput(): throws wrong type of exception instead of LogicException when the argument is a negative number.", false);
        }
        check("Source.getOutput(): does not throw exception when the index is a negative number.", ok);

        try {
            source.getOutput(1);
            ok = false;
        } catch (LogicException e) {
            check("Source.getOutput(): throws an exception with wrong message when the index is greater than 0.", ("Invalid index: 1").equals(e.getMessage()));
        } catch (Throwable e) {
            check("Source.getOutput(): throws wrong type of exception instead of LogicException the index is greater than 0.", false);
        }
        check("Source.getOutput(): does not throw exception when the index greater than 0.", ok);

        try {
            source.getOutput(0);
        } catch (Throwable e) {
            check("Source.getOutput(): throws an exception with correct index.", false);
        }

        Wire output = source.getOutput(0);

        source.switchOff();
        check("Source.switchOff(): the output of source should carry ZERO after invocation. (1)", output.getBit() == Bit.ZERO);

        source.switchOn();
        check("Source.switchOn(): the output of source should carry ONE after invocation.", output.getBit() == Bit.ONE);

        source.switchOff();
        check("Source.switchOff(): the output of source should carry ZERO after invocation. (2)", output.getBit() == Bit.ZERO);
    }

    public String description() { return "SourceTest"; }
    public String className() { return "node.Source"; }

    public Object[] expectedMethods() throws Exception {
        return new Object[]
            { constructor(className(), new Class[] {})
            , method(className() + ".getOutput", new Class[] { Integer.TYPE })
            , method(className() + ".switchOn")
            , method(className() + ".switchOff")
            };
    }

    public static void main(String... args) {
        Test.main(new SourceTest());
    }
}
