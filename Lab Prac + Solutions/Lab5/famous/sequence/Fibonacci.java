package famous.sequence;

public class Fibonacci {
    public static int fib(int n) { //nth fibonacci num
        if (n == 1) return 0;
        else if (n == 2) return 1;
        else return fib(n-1) + fib(n-2);

        //return n == 1 ? 0 : n == 2 ? 1 : fib(n-1) + fib(n-2);
    }
}