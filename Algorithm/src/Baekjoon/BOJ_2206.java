package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        boolean[][][] visit = new boolean[N][M][2];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++)
                arr[i][j] = s.charAt(j) - 48;
        }

        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1, 0});
        visit[0][0][0] = true;
        visit[0][0][1] = true;

        while (!queue.isEmpty()) {
            int[] q = queue.poll();

            if(q[0] == N-1 && q[1] == M-1) {
                System.out.println(q[2]);
                System.exit(0);
            }

            for(int k = 0; k < 4; k++) {
                int i = q[0] + di[k];
                int j = q[1] + dj[k];

                if(!(0 <= i && i < N && 0 <= j && j < M)) continue;

                if (arr[i][j] == 1) {
                    if (q[3] == 0 && !visit[i][j][1]) {
                        queue.offer(new int[]{i, j, q[2] + 1, 1});
                        visit[i][j][1] = true;
                    }
                }
                else {
                    if(!visit[i][j][q[3]]) {
                        queue.offer(new int[]{i, j, q[2] + 1, q[3]});
                        visit[i][j][q[3]] = true;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
