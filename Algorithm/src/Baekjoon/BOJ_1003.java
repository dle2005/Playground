package Baekjoon;

import java.util.Scanner;

public class BOJ_1003 {
    public static Integer[][] arr = new Integer[41][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            fibonacci(N);
            sb.append(arr[N][0]).append(" ").append(arr[N][1]).append("\n");
        }

        System.out.println(sb);
    }

    public static Integer[] fibonacci(int n) {
        if(arr[n][0] == null && arr[n][1] == null) {
            arr[n][0] = fibonacci(n-2)[0] + fibonacci(n-1)[0];
            arr[n][1] = fibonacci(n-2)[1] + fibonacci(n-1)[1];
        }

        return arr[n];
    }
}
