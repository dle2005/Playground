package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] box = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            box[i] = Integer.parseInt(st.nextToken());

            dp[i] = 1;
            for(int j = 0; j < i; j++)
                if(box[i] > box[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
        }

        int max = 0;
        for(int i : dp)
            max = Math.max(max, i);

        System.out.println(max);
    }
}
