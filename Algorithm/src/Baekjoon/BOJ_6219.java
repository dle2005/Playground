package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_6219 {
    public static boolean[] prime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int D = sc.nextInt();

        int count = 0;
        prime = new boolean[B+1];
        Arrays.fill(prime, true);

        isPrime(B);

        for(int i = A; i <= B; i++) {
            if(prime[i]) {
                String s = String.valueOf(i);
                if(s.contains(String.valueOf(D)))
                    count++;
            }
        }

        System.out.println(count);
    }

    public static void isPrime(int B) {
        prime[0] = prime[1] = false;

        for (int i = 2; i*i <= B; i++) {
            for(int j = i*i; j <= B; j+=i)
                prime[j] = false;
        }
    }
}
