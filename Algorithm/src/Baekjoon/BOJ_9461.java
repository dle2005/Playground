package Baekjoon;

import java.util.Scanner;

public class BOJ_9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        int[] arr = new int[T];
        int max = 0;

        for(int i = 0; i < T; i++) {
            arr[i] = sc.nextInt();
            if(max < arr[i]) max = arr[i];
        }

        long[] dp = new long[max + 1];

        if(max > 3) {
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;

            for(int i = 4; i <= max; i++)
                dp[i] = dp[i-2] + dp[i-3];
        }

        for(int i : arr) {
            if(i < 4)
                sb.append(1).append("\n");
            else
                sb.append(dp[i]).append("\n");
        }

        System.out.println(sb);
    }
}
