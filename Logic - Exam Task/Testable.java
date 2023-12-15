package utest;

public class Testable
{
    public void check(String str, boolean b)
    {
        if (!b) {
            System.out.println(str);
        }
    }
    public Object method(String str) { return null; }
    public Object method(String str, Class arr) { return null; }
    public Object method(String str, Class[] arr) { return null; }
    public Object staticMethod(String str) { return null; }
    public Object staticMethod(String str, Class arr) { return null; }
    public Object staticMethod(String str, Class[] arr) { return null; }
    public Object constructor(String str) { return null; }
    public Object constructor(String str, Class arr) { return null; }
    public Object constructor(String str, Class[] arr) { return null; }
    public Object staticField(String str) { return null; }
    public Object staticField(String str, Class arr) { return null; }
}