package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        BigInteger n = BigInteger.ONE;
        BigInteger r = BigInteger.ONE;

        for (int i = 0; i < M; i++) {
            n = n.multiply(new BigInteger(String.valueOf(N - i)));
            r = r.multiply(new BigInteger(String.valueOf(i + 1)));
        }

        System.out.println(n.divide(r));
    }
}
