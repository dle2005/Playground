package Baekjoon;

import java.util.Scanner;

public class BOJ_2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] card = new int[n];
        for(int i = 0; i < n; i++)
            card[i] = sc.nextInt();

        System.out.println(blackjeck(n, m, card));

        sc.close();
    }
    public static int blackjeck(int n, int m, int[] card) {
        int max = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 1; j < n && j != i; j++) {
                for (int k = 2; k < n && k != i && k != j; k++) {
                    int sum = card[i] + card[j] + card[k];
                    if (max < sum && sum <= m) max = sum;
                    if (max == m) return m;
                }
            }
        }
        return max;
    }
}
