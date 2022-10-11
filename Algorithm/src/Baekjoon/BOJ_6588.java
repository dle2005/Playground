package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6588 {
    public static boolean[] isPrime = new boolean[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        eratostenes();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            boolean flag = true;

            for (int i = 3; i <= n / 2; i++) {
                if (!isPrime[i] && !isPrime[n - i]) {
                    sb.append(n + " = " + i + " + " + (n - i)).append("\n");
                    flag = false;
                    break;
                }
            }

            if (flag) sb.append("Goldbach's conjecture is wrong").append("\n");
        }

        System.out.println(sb);
    }

    public static void eratostenes() {
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i * i <= 1_000_000; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= 1_000_000; j += i)
                    isPrime[j] = true;
            }
        }
    }
}
