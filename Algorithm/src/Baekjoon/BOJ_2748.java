package Baekjoon;

import java.util.Scanner;

public class BOJ_2748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if(n == 0) {
            System.out.println(0);
            return;
        }

        long[] arr = new long[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i <= n; i++)
            arr[i] = arr[i - 2] + arr[i - 1];


        System.out.println(arr[n]);
    }
}
