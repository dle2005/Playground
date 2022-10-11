package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {
    public static class Pos {
        int x;
        int y;
        int k;
        int cnt;

        public Pos(int x, int y, int k, int cnt) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];
        boolean[][][] visit = new boolean[K + 1][H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        Queue<Pos> queue = new LinkedList<>();
        int[][] horse = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        int[] di = {1, 0, -1, 0};
        int[] dj = {0, 1, 0, -1};

        queue.offer(new Pos(0, 0, 0, 0));
        visit[0][0][0] = true;

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            if (cur.x == H - 1 && cur.y == W - 1) {
                System.out.println(cur.cnt);
                return;
            }

            for (int k = 0; k < 4; k++) {
                int i = cur.x + di[k];
                int j = cur.y + dj[k];

                if (i < 0 || j < 0 || i >= H || j >= W) continue;
                if (visit[cur.k][i][j]) continue;
                if (map[i][j] == 1) continue;

                visit[cur.k][i][j] = true;
                queue.add(new Pos(i, j, cur.k, cur.cnt + 1));
            }

            if (cur.k == K) continue;

            for (int k = 0; k < 8; k++) {
                int i = cur.x + horse[k][0];
                int j = cur.y + horse[k][1];

                if (i < 0 || j < 0 || i >= H || j >= W) continue;
                if (visit[cur.k + 1][i][j]) continue;
                if (map[i][j] == 1) continue;

                visit[cur.k + 1][i][j] = true;
                queue.add(new Pos(i, j, cur.k + 1, cur.cnt + 1));
            }
        }

        System.out.println(-1);
    }
}
