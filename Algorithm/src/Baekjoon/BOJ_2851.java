package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0, diff = 100, answer = -1;

        for (int i = 0; i < 10; i++) {
            sum += Integer.parseInt(br.readLine());

            if (Math.abs(100 - sum) <= diff) {
                diff = Math.abs(100 - sum);
                answer = sum;
            }
        }

        System.out.println(answer);
    }
}
