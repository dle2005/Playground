package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < N; i++) {
            addLine(answer, i, N);
        }
        for (int i = N; i > 0; i--) {
            addLine(answer, i, N);
        }

        System.out.println(answer);
    }

    public static void addLine(StringBuilder sb, int i, int N) {
        addStar(sb, i);
        addSpace(sb, i, N);
        addStar(sb, i);

        sb.append("\n");
    }

    public static void addStar(StringBuilder sb, int i) {
        sb.append("*".repeat(Math.max(0, i)));
    }

    public static void addSpace(StringBuilder sb, int i, int N) {
        sb.append(" ".repeat(Math.max(0, N * 2 - i * 2)));
    }
}
