package programmers;

public class P_12945 {
    public static void main(String[] args) {
        System.out.println(solution(100000));
    }
    public static int solution(int n) {
        int answer = 0;

        int[] dp = new int[n+1];
        dp[1] = 1; dp[2] = 1;

        for(int i = 3; i <= n; i++)
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;

        return answer = dp[n];
    }
}
