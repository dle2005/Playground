package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0, cur = 0;

        for (int station = 1; station <= 4; station++) {
            String[] info = br.readLine().split(" ");
            int out = Integer.parseInt(info[0]);
            int in = Integer.parseInt(info[1]);

            cur = cur - out + in;
            answer = Math.max(answer, cur);
        }

        System.out.println(answer);
    }
}
