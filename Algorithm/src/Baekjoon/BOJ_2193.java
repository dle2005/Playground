package Baekjoon;

import java.util.Scanner;

public class BOJ_2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] arr = new long[N+1];

        arr[0] = 1;
        arr[1] = 1;

        for(int i = 2; i < N; i++)
            arr[i] = arr[i-2] + arr[i-1];

        System.out.println(arr[N-1]);
    }
}
