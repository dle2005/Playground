package LeetCode;

public class Reverse_Integer {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
    }
    public static int reverse(int x) {
        int answer = 0;

        while (x != 0) {
            int overflowCheck = answer * 10 + x % 10;

            if ((overflowCheck - x % 10) / 10 != answer) {
                return  0;
            }

            x /= 10;
            answer = overflowCheck;
        }

        return answer;
    }
}
