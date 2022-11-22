package LeetCode;

public class Pow_x_n {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
    }

    public static double myPow(double x, int n) {
        return Math.pow(x, n);
    }
}
