package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if (D == 0 && S > G) {
            System.out.println("use the stairs");
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visit = new boolean[F + 1];

        queue.add(new int[]{S, 0});
        visit[S] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == G) {
                System.out.println(cur[1]);
                return;
            }

            if (cur[0] + U <= F && !visit[cur[0] + U]) {
                queue.add(new int[]{cur[0] + U, cur[1] + 1});
                visit[cur[0] + U] = true;
            }

            if (cur[0] - D > 0 && !visit[cur[0] - D]) {
                queue.add(new int[]{cur[0] - D, cur[1] + 1});
                visit[cur[0] - D] = true;
            }
        }

        System.out.println("use the stairs");
    }
}
