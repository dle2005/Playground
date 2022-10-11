package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638 {
    public static int N, M;
    public static int[][] arr;

    public static int[] di = {0, 1, 0, -1};
    public static int[] dj = {1, 0, -1, 0};

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) count++;
            }
        }

        if(count == 0) {
            System.out.println(0);
            return;
        }

        for(int i = 1; i < Integer.MAX_VALUE; i++) {
            bfs();
            if(count == 0) {
                System.out.println(i);
                return;
            }
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> queue1 = new LinkedList<>();
        queue.offer(new int[]{0,0});

        boolean[][] visit = new boolean[N][M];
        visit[0][0] = true;

        int temp[][] = new int[N][M];
        for(int i = 0; i < N; i++)
            System.arraycopy(arr[i], 0, temp[i], 0, arr[i].length);

        while(!queue.isEmpty()) {
            int[] q = queue.poll();

            for(int k = 0; k < 4; k++) {
                int i = q[0] + di[k];
                int j = q[1] + dj[k];

                if(0 > i || i >= N || 0 > j || j >= M) continue;
                if(visit[i][j]) continue;

                if(arr[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visit[i][j] = true;
                }
                else if(arr[i][j] == 1) {
                    visit[i][j] = true;
                    queue1.offer(new int[]{i, j});
                }
            }
        }

        while (!queue1.isEmpty()) {
            int[] q = queue1.poll();
            int c = 0;

            for (int k = 0; k < 4; k++) {
                int i = q[0] + di[k];
                int j = q[1] + dj[k];

                if (0 > i || i >= N || 0 > j || j >= M) continue;

                if (arr[i][j] == 0 && visit[i][j]) {
                    c++;
                }

                if (c >= 2) {
                    temp[q[0]][q[1]] = 0;
                    count--;
                    break;
                }
            }
        }

        for(int i = 0; i < N; i++)
            System.arraycopy(temp[i], 0, arr[i], 0, temp[i].length);
    }
}
