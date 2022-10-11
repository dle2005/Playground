package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[] coin = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++)
                coin[j] = Integer.parseInt(st.nextToken());

            int price = Integer.parseInt(br.readLine());
            int[] dp = new int[price+1];
            dp[0] = 1;

            for(int j = 0; j < N; j++) {
                for(int k = 1; k <= price; k++) {
                    if(k >= coin[j]) {
                        dp[k] = dp[k] + dp[k-coin[j]];
                    }
                }
            }

            sb.append(dp[price]).append("\n");
        }

        System.out.println(sb);
    }
}
