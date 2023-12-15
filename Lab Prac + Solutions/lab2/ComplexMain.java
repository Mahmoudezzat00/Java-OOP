class ComplexMain {
    public static void main(String[] args) {
        Complex num1 = new Complex();
        num1.re = 3;
        num1.im = -2;

        Complex num2 = new Complex();
        num2.re = 1;
        num2.im = 4;

        num1.add(num2);  //changes will be on num1(this), num2 (that)
        System.out.println("Adding two numbers: " + num1.re + "  " + num1.im);
    }
}

/*
Classwork:
1) complete task3
2) solve task4 and task5
*/