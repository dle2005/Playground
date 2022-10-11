package Baekjoon;

import java.util.Scanner;

public class BOJ_4948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] notPrime = new int[123456 * 2 + 1];
        for(int i = 2; i <= 123456 * 2; i++)
            notPrime[i] = i;

        for(int i = 2; i <= 123456; i++)
            for (int j = i * 2; j <= 123456 * 2; j += i)
                notPrime[j] = 0;


        while (true) {
            int n = sc.nextInt();
            int count = 0;

            if(n == 0) break;

            for(int i = n + 1; i <= 2 * n && i <= 123456 * 2; i++)
                if (notPrime[i] != 0) count++;

            System.out.println(count);
        }

        sc.close();
    }
}
