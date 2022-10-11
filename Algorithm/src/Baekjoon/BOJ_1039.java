package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int len = String.valueOf(N).length();

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});

        boolean[][] visit = new boolean[1000001][11];
        visit[N][0] = true;

        while (!queue.isEmpty()) {
            if (queue.peek()[1] == K) break;

            int[] cur = queue.poll();

            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    int next = solve(cur[0], i, j);
                    if (next != -1 && !visit[next][cur[1] + 1]) {
                        visit[next][cur[1] + 1] = true;
                        queue.add(new int[]{next, cur[1] + 1});
                    }
                }
            }
        }

        int result = -1;
        while (!queue.isEmpty()) {
            int[] peek = queue.poll();

            if (result < peek[0]) result = peek[0];
        }

        System.out.println(result);
    }

    public static int solve(int n, int i, int j) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);

        if (i == 0 && sb.charAt(j) == '0') return -1;

        char t = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, t);

        return Integer.parseInt(sb.toString());
    }
}
