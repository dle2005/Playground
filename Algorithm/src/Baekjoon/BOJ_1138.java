package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] people = new int[N];
        for (int i = 0; i < N; i++) people[i] = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = N - 1; i >= 0; i--)
            list.add(people[i], i + 1);

        for (int person : list) sb.append(person).append(" ");

        System.out.println(sb);
    }
}
