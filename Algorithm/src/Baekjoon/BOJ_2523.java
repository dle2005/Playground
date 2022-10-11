package Baekjoon;

import java.util.Scanner;

public class BOJ_2523 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 1; i < 2 * n; i++) {
            if(i <= n) {
                for(int j = 0; j < i; j++)
                    System.out.print("*");
            }
            else {
                for(int j = n - i % n; j > 0; j--)
                    System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}
