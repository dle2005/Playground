package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10211 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int[] dp = new int[N];
            int max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < N; i++) {
                dp[i] = Integer.parseInt(st.nextToken());

                max = Math.max(max, dp[i]);
                if (i == 0) continue;

                dp[i] = Math.max(dp[i], dp[i - 1] + dp[i]);
                max = Math.max(max, dp[i]);
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}
