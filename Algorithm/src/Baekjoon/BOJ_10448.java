package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] T = new int[45];
        for (int i = 1; i < 45; i++) T[i] = (i * (i + 1))/2;

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            int K = Integer.parseInt(br.readLine());
            int answer = 0;

            loop:
            for (int i = 1; i < 45; i++) {
                for (int j = 1; j < 45; j++) {
                    for (int k = 1; k < 45; k++) {
                        if (T[i] + T[j] + T[k] == K) {
                            answer = 1;
                            break loop;
                        }

                        if (T[i] + T[j] + T[k] > K) break;
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
