class Calculator {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Invalid number of command line arguments!");
            System.exit(0);
        } else { //args.length == 2
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            System.out.println("a + b = " + (a+b));
            System.out.println("a - b = " + (a-b));
            System.out.println("a * b = " + (a*b));
            if (b != 0) {
                System.out.println("a / b = " + (a/b));
                System.out.println("a % b = " + (a%b));
            }
        }

    }
}