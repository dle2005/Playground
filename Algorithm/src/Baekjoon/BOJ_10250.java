package Baekjoon;

import java.util.Scanner;

public class BOJ_10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int h = 0, w = 0, n = 0;

        for(int i = 0; i < t; i++) {
            h = sc.nextInt();
            w = sc.nextInt();
            n = sc.nextInt();

            if(n % h == 0) System.out.println(h * 100 + n / h);
            else System.out.println((n % h * 100) + n / h + 1);
        }

        sc.close();
    }
}
