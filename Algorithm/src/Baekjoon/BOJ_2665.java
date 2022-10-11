package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_2665 {
    public static class Pos implements Comparable<Pos>{
        int x;
        int y;
        int cnt;

        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pos o) {
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        boolean[][] visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) map[i][j] = s.charAt(j) - '0';
        }

        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};

        PriorityQueue<Pos> queue = new PriorityQueue<>();
        queue.offer(new Pos(0, 0, 0));
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            if (cur.x == N - 1 && cur.y == N - 1) {
                System.out.println(cur.cnt);
                return;
            }

            for (int k = 0; k < 4; k++) {
                int i = cur.x + di[k];
                int j = cur.y + dj[k];

                if (i < 0 || j < 0 || i >= N || j >= N) continue;
                if (visit[i][j]) continue;

                if (map[i][j] == 0) queue.offer(new Pos(i, j, cur.cnt + 1));
                else queue.offer(new Pos(i, j, cur.cnt));
                visit[i][j] = true;
            }
        }
    }
}
