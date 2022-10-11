package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261 {
    public static class Pos implements Comparable<Pos> {
        int x;
        int y;
        int block;

        public Pos(int x, int y, int block) {
            this.x = x;
            this.y = y;
            this.block = block;
        }

        @Override
        public int compareTo(Pos o) {
            return this.block - o.block;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];
        boolean[][] visit = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String s = br.readLine();

            for(int j = 0; j < N; j++)
                map[i][j] = s.charAt(j) - '0';
        }


        int di[] = {0, 1, 0, -1};
        int dj[] = {1, 0, -1, 0};

        PriorityQueue<Pos> queue = new PriorityQueue<>();
        queue.offer(new Pos(0, 0, 0));
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            if(cur.x == M-1 && cur.y == N-1) {
                System.out.println(cur.block);
                return;
            }

            for (int k = 0; k < 4; k++) {
                int i = cur.x + di[k];
                int j = cur.y + dj[k];

                if(i < 0 || j < 0 || i >= M || j >= N) continue;

                if (!visit[i][j] && map[i][j] == 1) {
                    visit[i][j] = true;
                    queue.offer(new Pos(i, j, cur.block + 1));
                } else if(!visit[i][j] && map[i][j] == 0) {
                    visit[i][j] = true;
                    queue.offer(new Pos(i, j, cur.block));
                }
            }
        }
    }
}
