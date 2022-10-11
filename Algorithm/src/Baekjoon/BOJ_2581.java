package Baekjoon;

import java.util.Scanner;

public class BOJ_2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int sum = 0, min = N;

        for(int i = M; i <= N; i++) {
            boolean isPrime = true;

            if(i <= 1) isPrime = false;
            else {
                for(int j = 2; j < i; j++) {
                    if(i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if(isPrime) {
                sum += i;
                if(i < min) min = i;
            }
        }
        if(sum == 0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }

        sc.close();
    }
}
