package Baekjoon;

import java.util.Scanner;

public class BOJ_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int temp = n;

        if(n % 5 == 0) {
            System.out.println(n / 5);
            return;
        }
        else {
            for(int i = n / 5; i > 0; i--) {
                temp = n - i * 5;
                if(temp % 3 == 0) {
                    System.out.println(i + temp / 3);
                    return;
                }
            }
        }

        if(n % 3 == 0) {
            System.out.println(n / 3);
            return;
        }
        else System.out.println(-1);

        sc.close();
    }
}
