package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringBuilder s = new StringBuilder(br.readLine());
            s.setCharAt(0, Character.toUpperCase(s.charAt(0)));
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
