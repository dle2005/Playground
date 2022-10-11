package Baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_2226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        BigInteger[] arr = new BigInteger[Math.max(N+1, 3)];
        arr[1] = BigInteger.valueOf(0);
        arr[2] = BigInteger.valueOf(1);

        for(int i = 3; i <= N; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i - 1].multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(1));
            } else {
                arr[i] = arr[i - 1].multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(-1));
            }
        }

        System.out.println(arr[N]);
    }
}
