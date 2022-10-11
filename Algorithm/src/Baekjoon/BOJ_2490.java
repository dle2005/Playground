package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            answer.append(getYut(br.readLine().split(" "))).append("\n");
        }

        System.out.println(answer);
    }

    public static char getYut(String[] input) {
        int front = 0, back = 0;

        for (String yut : input) {
            if (yut.equals("0")) {
                front++;
            } else {
                back++;
            }
        }

        return convertYutToChar(front, back);
    }

    public static char convertYutToChar(int front, int back) {
        if (front == 1 && back == 3) {
            return 'A';
        } else if (front == 2 && back == 2) {
            return 'B';
        } else if (front == 3 && back == 1) {
            return 'C';
        } else if (front == 4 && back == 0) {
            return 'D';
        } else {
            return 'E';
        }
    }
}
