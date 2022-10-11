package Baekjoon;

import java.util.Scanner;

public class BOJ_1065 {
    private static boolean isHansu(int n) {
        int a = n / 100;
        int b = n % 100 / 10;
        int c = n % 10;

        if(b * 2 == a + c) return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = 99;

        if(n < 100) result = n;
        else {
            for(int i = 100; i <= n; i++) {
                if(isHansu(i)) result++;
            }
        }

        System.out.println(result);

        sc.close();
    }
}
