package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] dp = new long[1001];
        dp[0] = 1; dp[1] = 1; dp[2] = 2; dp[3] = 5; dp[4] = 14;

        int last_index = 5;

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            for(int i = last_index; i <= N; i++) {
                long sum = 0;

                for(int j = 0; j < i; j++)
                    sum += dp[j] * dp[i - j - 1];

                dp[i] = sum;
            }

            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);
    }
}
