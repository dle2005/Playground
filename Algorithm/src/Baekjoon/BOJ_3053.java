package Baekjoon;

import java.util.Scanner;

public class BOJ_3053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();

        System.out.printf("%.6f\n", Math.PI * r * r);
        System.out.printf("%.6f\n", (double)2 * r * r);
        
        sc.close();
    }
}
