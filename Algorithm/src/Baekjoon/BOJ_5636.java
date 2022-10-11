package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5636 {
    public static boolean[] isPrime = new boolean[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        eratosthenes();

        while (true) {
            char[] arr = br.readLine().toCharArray();
            if (arr.length == 1 && arr[0] == '0') break;

            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                int n = 0;

                for (int j = i; j < Math.min(i + 5, arr.length); j++) {
                    n = (n * 10) + arr[j] - '0';

                    if (!isPrime[n]) max = Math.max(n, max);
                }
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }

    public static void eratosthenes() {
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i * i <= 100_000; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= 100_000; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    }
}
