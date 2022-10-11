package Baekjoon;

import java.util.Scanner;

public class BOJ_2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int k = 0, n = 0;

        for(int i = 0; i < t; i++) {
            k = sc.nextInt();
            n = sc.nextInt();

            System.out.println(apt(k,n));
        }

        sc.close();
    }
    private static int apt(int k, int n) {
        if(n == 0) return 0;
        else if(k == 0) return n;
        else return apt(k, n - 1) + apt(k - 1, n);
    }
}
