package Baekjoon;

import java.util.Scanner;

public class BOJ_9020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int[] notPrime = new int[10001];
        for(int i = 1; i < 10001; i++)
            notPrime[i] = i;

        for(int i = 2; i < 10001; i++)
            for (int j = i * 2; j < 10000; j += i)
                notPrime[j] = 0;

        for(int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int min = n / 2;
            int max = n / 2;

            while(true) {
                if(notPrime[min] != 0 && notPrime[max] != 0) {
                    System.out.println(min + " " + max);
                    break;
                }

                min--;
                max++;
            }
        }

        sc.close();
    }
}
