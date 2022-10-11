package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2670 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double[] arr = new double[N];
        double[] dp = new double[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        double answer = dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(Math.max(arr[i], arr[i - 1] * arr[i]), dp[i - 1] * arr[i]);

            answer = Math.max(answer, dp[i]);
        }

        System.out.printf("%.3f", answer);
    }
}
