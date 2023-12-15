class Greet2 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Invalid number of command-line arguments!");
            System.exit(0);
        } else {
            System.out.println("Hello " + args[0] + " "+args[1]); //
        }
    }
}