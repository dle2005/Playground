package Baekjoon;

import java.util.Scanner;

public class BOJ_10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = factorial_n(n);
        System.out.println(result);

        sc.close();
    }
    public static int factorial_n(int n) {
        if(n <= 1) return 1;
        return n * factorial_n(n - 1);
    }
}
