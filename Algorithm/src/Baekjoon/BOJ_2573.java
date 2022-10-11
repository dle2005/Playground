package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {
    public static int N, M;
    public static int[][] iceberg;
    public static int[][] melt;
    public static boolean[][] visit;

    public static int[] di = {0, 1, 0, -1};
    public static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        iceberg = new int[N][M];
        melt = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++)
                iceberg[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int k = 0; k <= Integer.MAX_VALUE; k++) {
            int count = 0;
            visit = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visit[i][j] && iceberg[i][j] != 0) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            if(count == 0) {
                System.out.println(0);
                return;
            }
            else if(count >= 2) {
                System.out.println(k);
                return;
            }

            melt();
        }
    }

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visit[i][j] = true;

        while(!queue.isEmpty()) {
            int[] q = queue.poll();

            for(int k = 0; k < 4; k++) {
                int ii = q[0] + di[k];
                int jj = q[1] + dj[k];

                if(0 > ii || ii >= N || 0 > jj || jj >= M) continue;

                if(iceberg[ii][jj] == 0)
                    melt[q[0]][q[1]]++;

                if(!visit[ii][jj] && iceberg[ii][jj] != 0) {
                    queue.offer(new int[]{ii, jj});
                    visit[ii][jj] = true;
                }
            }
        }
    }

    public static void melt() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                iceberg[i][j] = Math.max(0, iceberg[i][j] - melt[i][j]);

                melt[i][j] = 0;
            }
        }
    }
}
