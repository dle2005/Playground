package programmers;

public class P_12900 {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }
    public static int solution(int n) {
        int answer = 0;

        int[] dp = new int[Math.max(2, n+1)];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; i++)
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;

        return answer = dp[n];
    }
}
