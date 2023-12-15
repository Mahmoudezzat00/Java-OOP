class PerfectRange {
    public static void main(String[] args) {
        if (args.length == 1) {
            int num = Integer.parseInt(args[0]);
            int counter = 0;
            for (int i = 1; i <= num; i++) {
                int sum = 0;
                for (int j = 1; j <= i/2; j++) {
                    if (i%j == 0) {
                        sum += j;
                    }
                }
                if (sum == i) {
                    System.out.println(i);
                    counter += 1;
                }
            }
            if (counter == 0) {
                System.out.println("there are no perfect numbers in the range of 1 to " + num);
            } else {
                System.out.println("There are " + counter + " perfect numbers in this range!");
            }
        } else {
            System.err.println("You should give exactly 1 number!");
            System.exit(0);
        }
    }
}