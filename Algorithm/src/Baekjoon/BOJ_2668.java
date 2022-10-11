package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2668 {
    public static int N;
    public static int[] arr;
    public static boolean[] visit;
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visit[i] = true;
            dfs(i, i);
            visit[i] = false;
        }

        Collections.sort(list);

        StringBuilder answer = new StringBuilder();
        answer.append(list.size()).append("\n");
        for (int n : list) {
            answer.append(n).append("\n");
        }
        System.out.println(answer);
    }

    public static void dfs(int idx, int start) {
        if (!visit[arr[idx]]) {
            visit[arr[idx]] = true;
            dfs(arr[idx], start);
            visit[arr[idx]] = false;
        }

        if (arr[idx] == start) {
            list.add(start);
        }
    }
}
