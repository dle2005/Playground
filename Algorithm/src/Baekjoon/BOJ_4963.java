package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_4963 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] di = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dj = {1, 0, -1, 0, 1, -1, 1, -1};

        while (true) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);

            if (n == 0 && m == 0) break;

            int[][] map = new int[n][m];
            boolean[][] visit = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                String[] row = br.readLine().split(" ");
                for(int j = 0; j < m; j++)
                    map[i][j] = Integer.parseInt(row[j]);
            }

            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[]{i, j});
                        visit[i][j] = true;
                        cnt++;

                        while (!queue.isEmpty()) {
                            int[] q = queue.poll();

                            for (int k = 0; k < 8; k++) {
                                int ii = q[0] + di[k];
                                int jj = q[1] + dj[k];

                                if(ii < 0 || jj < 0 || ii >= n || jj >= m) continue;
                                if(visit[ii][jj] || map[ii][jj] == 0) continue;

                                visit[ii][jj] = true;
                                queue.offer(new int[]{ii, jj});
                            }
                        }
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
