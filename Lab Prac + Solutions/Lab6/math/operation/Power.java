package math.operation;

public class Power {

    //  public static double power(int base, int exp) {
    //     double result = 1;
    //     for (int i = 1; i <= Math.abs(exp); ++i)
    //     {
    //         result *= base;
    //     }
    //     return result;
    // }

    public static double power(int base, int exp) { //3^2
        double result = 1;
        for (int i =1; i <= Math.abs(exp); ++i) {
            result *= base;
        }

        if (exp < 0) {
            if (base == 0) {
                throw new IllegalArgumentException();
            }
            result = 1.0/result;
        }
        return result;
    }
}