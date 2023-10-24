public class CustomMath {
    public static final double PI = Math.PI;
    public static final double E = Math.E;

    /*
     * Why is it safe to make these variable public?
     * We would make this variable public because we do not want to have getter methods for these variables.
     *
     * How do you access these variables from another class?
     * In another class we could access/call these variables through
     */

    public int max(int a, int b) {
        if(a > b) {
            return a;
        }
        return b;
    }

    public double min(double a, double b) {
        if(a > b) {
            return b;
        }
        return a;
    }

    public static int pow(int base, int exponent) {
        int finalNum = base;
        for(int i = 1; i < exponent; i++) {
            finalNum *= base;
        }
        return finalNum;
    }
}
