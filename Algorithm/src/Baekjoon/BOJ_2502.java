package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int first = 1, second = 1;
        int[] dp = new int[D + 1];

        while (true) {
            dp[1] = first;
            dp[2] = second;

            for (int i = 3; i <= D; i++)
                dp[i] = dp[i-1] + dp[i-2];

            if (dp[D] == K)  break;
            else if (dp[D] < K) second++;
            else {
                first++;
                second--;
            }
        }

        System.out.println(first);
        System.out.println(second);
    }
}
