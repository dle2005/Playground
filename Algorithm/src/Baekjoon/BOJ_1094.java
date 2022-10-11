package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int short_stick = 64;
        int answer = 0;

        while (X > 0) {
            if(short_stick > X)
                short_stick /= 2;
            else {
                answer++;
                X -= short_stick;
            }
        }

        System.out.println(answer);
    }
}
