package Baekjoon;

import java.util.Scanner;

public class BOJ_1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int new_n = n, cycle = 0, a = 0, b = 0;

        while(true) {
            a = new_n / 10;
            b = new_n % 10;

            new_n = b * 10 + (a + b) % 10;
            cycle++;

            if(new_n == n) break;
        }

        System.out.println(cycle);

        sc.close();
    }
}
