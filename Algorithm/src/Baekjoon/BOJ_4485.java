package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485 {
    public static int N;
    public static int[][] map;
    public static boolean[][] visit;

    public static int[] di = {1, 0, -1, 0};
    public static int[] dj = {0, 1, 0, -1};

    public static class Pos implements Comparable<Pos> {
        int x;
        int y;
        int n;

        public Pos(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }

        @Override
        public int compareTo(Pos o) {
            return this.n - o.n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; ; t++) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            map = new int[N][N];
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            sb.append("Problem " + t + ": ");
            sb.append(Dijkstra()).append("\n");
        }

        System.out.println(sb);
    }

    public static int Dijkstra() {
        int dist = map[0][0];
        visit[0][0] = true;

        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.offer(new Pos(0, 0, dist));

        while (!pq.isEmpty()) {
            Pos cur = pq.poll();

            if (cur.x == N - 1 && cur.y == N - 1) return cur.n;

            for (int k = 0; k < 4; k++) {
                int i = cur.x + di[k];
                int j = cur.y + dj[k];

                if (i < 0 || j < 0 || i >= N || j >= N) continue;
                if (visit[i][j]) continue;

                visit[i][j] = true;
                pq.offer(new Pos(i, j, cur.n + map[i][j]));
            }
        }

        return dist;
    }
}
