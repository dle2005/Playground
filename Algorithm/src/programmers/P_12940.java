package programmers;

public class P_12940 {
    class Solution {
        public int[] solution(int n, int m) {
            int a = Math.max(n, m);
            int b = Math.min(n, m);

            int gcd = gcd(a, b);

            return new int[]{gcd, a * b / gcd};
        }

        public int gcd(int a, int b) {
            if (a % b == 0) {
                return b;
            }

            return gcd(b, a % b);
        }
    }
}
