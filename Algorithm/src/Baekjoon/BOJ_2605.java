package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());

            int idx = list.size() - n;
            list.add(idx, i);
        }

        StringBuilder answer = new StringBuilder();
        for (int n : list) {
            answer.append(n).append(" ");
        }
        answer.setLength(answer.length() - 1);

        System.out.println(answer);
    }
}
