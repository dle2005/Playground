package Baekjoon;

import java.util.Scanner;

public class BOJ_10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int min = 100001, max = -1000001;

        for(int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if(x < min) min = x;
            if(x > max) max = x;
        }

        System.out.println(min + " " + max);
    }
}
