package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String regex = "^[A-F]?A+F+C+[A-F]?$";

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            if(s.matches(regex))
                sb.append("Infected!").append("\n");
            else sb.append("Good").append("\n");
        }

        System.out.println(sb);
    }
}
