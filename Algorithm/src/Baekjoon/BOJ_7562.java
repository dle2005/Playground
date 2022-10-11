package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {
    public static class Pos {
        int i;
        int j;
        int move;

        public Pos(int i, int j, int move) {
            this.i = i;
            this.j = j;
            this.move = move;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int[] di = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dj = {1, 2, 2, 1, -1, -2, -2, -1};

        while (T-- > 0) {
            int l = Integer.parseInt(br.readLine());
            boolean[][] visit = new boolean[l][l];

            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int dest_x = Integer.parseInt(st.nextToken());
            int dest_y = Integer.parseInt(st.nextToken());

            Queue<Pos> queue = new LinkedList<>();
            queue.offer(new Pos(x, y, 0));
            visit[x][y] = true;

            int answer = 0;

            while (!queue.isEmpty()) {
                Pos p = queue.poll();

                if (p.i == dest_x && p.j == dest_y) {
                    answer = p.move;
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int ii = p.i + di[i];
                    int jj = p.j + dj[i];

                    if(ii < 0 || jj < 0 || ii >= l || jj >= l) continue;

                    if (!visit[ii][jj]) {
                        visit[ii][jj] = true;
                        queue.offer(new Pos(ii, jj, p.move + 1));
                    }
                }
            }

            System.out.println(answer);
        }
    }
}
