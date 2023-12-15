class PerfectNum {
    public static void main(String[] args) {
        if (args.length == 1) {
            int num = Integer.parseInt(args[0]);
            //find the divisors of num, except num itsef
            //sum
            //if sum == num
            int sum = 0;
            for (int i = 1; i <= num/2;i++) {
                if (num%i == 0) {
                    sum += i;
                }
            }
            if (sum == num) {
                System.out.println("The number is perfect!");
            } else {
                System.out.println("The number is not perfect!");
            }
        } else {
            System.err.println("You should give exactly 1 number!");
            System.exit(0);
        }
    }
}