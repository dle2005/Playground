package Baekjoon;

import java.util.Scanner;

public class BOJ_1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][];
        for(int i = 0; i < n; i++)
            arr[i] = new int[i+1];

        arr[0][0] = sc.nextInt();
        for(int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = sc.nextInt();

                if(j == 0)
                    arr[i][j] += arr[i-1][j];
                else if (j == i)
                    arr[i][j] += arr[i-1][j-1];
                else
                    arr[i][j] += Math.max(arr[i-1][j], arr[i-1][j-1]);
            }
        }

        int max = 0;
        for(int i : arr[n-1])
            if(i > max) max = i;

        System.out.println(max);
    }
}
