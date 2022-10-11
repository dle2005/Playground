package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2635 {
    public static List<Integer> answer, list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        answer = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list = new ArrayList<>();
            getCnt(N, i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for (int n : answer) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }

    public static void getCnt(int front, int back) {
        if (front < 0) {
            if (answer.size() < list.size()) {
                answer = list;
            }

            return;
        }

        list.add(front);

        getCnt(back, front - back);
    }
}
