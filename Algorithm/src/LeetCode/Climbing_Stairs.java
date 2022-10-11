package LeetCode;

public class Climbing_Stairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int idx = 2; idx <= n; idx++) {
            dp[idx] = dp[idx - 1] + dp[idx - 2];
        }

        return dp[n];
    }
}
