package Baekjoon;

import java.util.Scanner;

public class BOJ_10951 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = 0, b = 0;

        while(sc.hasNextInt()) {
            a = sc.nextInt();
            b = sc.nextInt();

            System.out.println(a + b);
        }

        sc.close();
    }
}
