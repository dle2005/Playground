package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_10826 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        BigInteger[] fibonacci = new BigInteger[Math.max(n + 1, 2)];

        fibonacci[0] = BigInteger.ZERO;
        fibonacci[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++)
            fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2]);

        System.out.println(fibonacci[n]);
    }
}
