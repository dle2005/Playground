package Baekjoon;

import java.util.Scanner;

public class BOJ_10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] input = new int[n];

        for(int i = 0; i < n; i++)
            input[i] = sc.nextInt();

        for(int i = 0; i < n; i++)
            if(input[i] < x)
                System.out.print(input[i] + " ");

        sc.close();
    }
}
