class Half {
    public static void main(String[] args) {
        int from = Integer.parseInt(System.console().readLine("Give me the lower bound: "));
        int to = Integer.parseInt(System.console().readLine("Give me the upper bound: "));

        if (from > to ) System.err.println("The lower bound should not be bigger than the upper bound!!");
        
        for (int index = from; index <= to; index++) {
            System.out.println("the half of " + index + " is: " + index/2.0);
        }
    }
}