package Baekjoon;

import java.util.Scanner;

public class BOJ_1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;

        for(int i = 0; i < N; i++) {
            int n = sc.nextInt();
            boolean isPrime = true;

            if(n <= 1) isPrime = false;
            else {
                for (int j = 2; j < n; j++) {
                    if (n % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if(isPrime) count++;
        }

        System.out.println(count);

        sc.close();
    }
}
