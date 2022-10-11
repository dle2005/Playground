package Baekjoon;

import java.util.Scanner;

public class BOJ_1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;

        for(int i = 0; ; i++) {
            String temp = Integer.toString(i);

            if(temp.contains("666")) count++;

            if(count == n) {
                System.out.println(i);
                break;
            }
        }

        sc.close();
    }
}
