package Baekjoon;

import java.util.Scanner;

public class BOJ_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] notPrime = new int[N+1];

        for(int i = 2; i <= N; i++)
            notPrime[i] = i;

        for(int i = 2; i <= N; i++) {
            for(int j = i * 2; j <= N; j += i)
                notPrime[j] = 0;
        }

        for(int i = M; i <= N; i++)
            if(notPrime[i] != 0) System.out.println(i);
        
        sc.close();    
    }
}
