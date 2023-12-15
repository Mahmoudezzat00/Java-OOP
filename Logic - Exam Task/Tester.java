package utest;

//javac -d . Test.java TestRunner.java Tester.java Testable.java tests\AndTest.java tests\AndTest.java tests\BitTest.java tests\GateTest.java tests\LedTest.java tests\SourceTest.java tests\WireTest.java
//java utest.Test

public class Tester
{
    public static void run(String str)
    {
        if (str.equals("tests.BitTest")) {
            new tests.BitTest().assertion();
        } else if (str.equals("tests.WireTest")) {
            new tests.WireTest().assertion();
        } else if (str.equals("tests.GateTest")) {
            new tests.GateTest().assertion();
        } else if (str.equals("tests.LedTest")) {
            new tests.LedTest().assertion();
        } else if (str.equals("tests.SourceTest")) {
            new tests.SourceTest().assertion();
        } else if (str.equals("tests.AndTest")) {
            new tests.AndTest().assertion();
        }
    }
}