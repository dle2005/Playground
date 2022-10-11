package Baekjoon;

import java.util.Scanner;

public class BOJ_7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] w = new int[n];
        int[] h = new int[n];
        int[] r = new int[n];
        for(int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            h[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            int rank = 1;
            for(int j = 0; j < n; j++) {
                if(w[i] < w[j] && h[i] < h[j]) rank++;
            }
            r[i] = rank;
        }

        for(int i = 0; i < n; i++)
            System.out.printf("%d ", r[i]);
    }
}
