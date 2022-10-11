package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2442 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0, space = N - 1; i < N; i++, space--) {
            for (int s = 0; s < space; s++) sb.append(" ");
            for (int star = 0; star < i * 2 + 1; star++) sb.append("*");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
