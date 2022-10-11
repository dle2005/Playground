package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[5001];
        dp[0] = dp[2] = 1;

        for (int i = 4; i <= 30; i += 2) {
            for (int j = 0; j < i; j += 2) {
                dp[i] += dp[j] * dp[i - j - 2];
                dp[i] %= 1_000_000_007;
            }
        }

        while (T-- > 0) sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");

        System.out.println(sb);
    }
}
