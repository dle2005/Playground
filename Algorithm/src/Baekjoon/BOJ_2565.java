package Baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_2565 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int[][] arr = new int[A][2];
        int[] dp = new int[A];

        for(int i = 0; i < A; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < A; i++) {
            dp[i] = 1;

            for(int j = 0; j < i; j++) {
                if(arr[i][1] > arr[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int result = 0;
        for(int i : dp)
            if(i > result) result = i;
        System.out.println(A - result);
    }
}
