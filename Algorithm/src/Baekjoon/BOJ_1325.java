package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1325 {
    public static List<Integer>[] list;
    public static boolean[] visit;
    public static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new List[N + 1];
        for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[b].add(a);
        }

        answer = new int[N + 1];

        int max = 0;
        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            visit[i] = true;
            dfs(i, i);
            max = Math.max(max, answer[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (answer[i] == max) sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    public static void dfs(int cur, int start) {
        for (int next : list[cur]) {
            if (!visit[next]) {
                answer[start]++;
                visit[next] = true;
                dfs(next, start);
            }
        }
    }
}
