package Baekjoon;

import java.util.Scanner;

public class BOJ_1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N][3];

        arr[0][0] = sc.nextInt();
        arr[0][1] = sc.nextInt();
        arr[0][2] = sc.nextInt();

        for(int i = 1; i < N; i++) {
            arr[i][0] = Math.min(arr[i-1][1], arr[i-1][2]) + sc.nextInt();
            arr[i][1] = Math.min(arr[i-1][0], arr[i-1][2]) + sc.nextInt();
            arr[i][2] = Math.min(arr[i-1][0], arr[i-1][1]) + sc.nextInt();
        }

        int min = arr[N-1][0];
        for(int i = 1; i < 3; i++)
            if(min > arr[N-1][i])
                min = arr[N-1][i];

        System.out.println(min);
    }
}
