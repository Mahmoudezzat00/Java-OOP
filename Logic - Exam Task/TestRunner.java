package utest;

import utest.*;

public class TestRunner extends Tester {
    public static void doit() {
        run("tests.BitTest");
        run("tests.WireTest");
        run("tests.GateTest");
        run("tests.LedTest");
        run("tests.SourceTest");
        run("tests.AndTest");
    }
}
