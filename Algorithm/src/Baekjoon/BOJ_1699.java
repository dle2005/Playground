package Baekjoon;

import java.util.Scanner;

public class BOJ_1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N+1];


        for(int i = 1; i <= N; i++) {
            int n = i;
            int count = 0;

            while(n > 0) {
                int root = (int)Math.sqrt(n);
                int pow = (int)Math.pow(root, 2);

                n -= pow;
                count++;
            }

            for(int j = 1; j < (int)Math.sqrt(i); j++) {
                int x = (int)Math.pow(j, 2);

                count = Math.min(count, arr[x] + arr[i - x]);
            }

            arr[i] = count;
        }

        System.out.println(arr[N]);
    }
}
