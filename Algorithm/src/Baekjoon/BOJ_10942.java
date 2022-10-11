package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) num[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        boolean[][] dp = new boolean[N+1][N+1];

        for(int i = 1; i <= N; i++)
            dp[i][i] = true;

        for(int i = 1; i < N; i++) {
            if(num[i] == num[i+1]) dp[i][i+1] = true;
        }

        for(int i = 2; i < N; i++) {
            for(int j = 1; j <= N - i; j++) {
                if(num[j] == num[i+j] && dp[j+1][i+j-1])
                    dp[j][j+i] = true;
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(dp[a][b]) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);
    }
}
