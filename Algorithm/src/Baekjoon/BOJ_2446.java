package Baekjoon;

import java.util.Scanner;

public class BOJ_2446 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++)
                System.out.print(" ");
            for(int j = 0; j < 2 * n - i * 2 -1; j++)
                System.out.print("*");
            System.out.println();
        }
        for(int i = 0; i < n - 1; i++) {
            for(int j = n - 2 -i; j > 0; j--)
                System.out.print(" ");
            for(int j = 0; j < 3 + i * 2; j++)
                System.out.print("*");
            System.out.println();
        }
        
        sc.close();
    }
}
