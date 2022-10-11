package Baekjoon;

import java.util.Scanner;

public class BOJ_10950 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        int a = 0, b = 0;
        
        for(int i = 0; i < t; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            System.out.println(a+b);
        }
        
        sc.close();
    }
}
