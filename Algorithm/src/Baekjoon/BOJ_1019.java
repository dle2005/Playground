package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] cnt = new int[10];
        int start = 1, point = 1;

        while (start <= N) {
            while (N % 10 != 9 && start <= N) {
                cal(N, cnt, point);
                N--;
            }

            if (N < start) break;

            while (start % 10 != 0 && start <= N) {
                cal(start, cnt, point);
                start++;
            }

            start /= 10;
            N /= 10;

            for (int i = 0; i < 10; i++) {
                cnt[i] += (N - start + 1) * point;
            }

            point *= 10;
        }

        StringBuilder answer = new StringBuilder();
        for (int n : cnt) {
            answer.append(n).append(" ");
        }
        answer.setLength(answer.length() - 1);

        System.out.println(answer);
    }

    public static void cal(int x, int[] cnt, int point) {
        while (x > 0) {
            cnt[x % 10] += point;
            x /= 10;
        }
    }
}
