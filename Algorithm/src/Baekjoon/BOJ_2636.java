package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {
    public static int[][] arr;
    public static int N, M;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int last = bfs();
        if(last == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }
        else {
            for (int i = 1; i <= 10; i++) {
                int end = bfs();
                if (end == 0) {
                    System.out.println(i);
                    System.out.println(last);
                    return;
                }
                last = end;
            }
        }
    }

    public static int bfs() {
        boolean[][] visit = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        int temp[][] = new int[N][M];
        for(int i = 0; i < N; i++)
            System.arraycopy(arr[i], 0, temp[i], 0, arr[i].length);
        int count = 0;
        visit[0][0] = true;

        q.offer(new int[]{0,0});
        while(!q.isEmpty()) {
            int[] top = q.poll();
            int i = top[0], j = top[1];

            for(int k = 0; k < 4; k++) {
                int n_i = i + dx[k];
                int n_j = j + dy[k];

                if(0 <= n_i && n_i < N && 0 <= n_j && n_j < M) {
                    if (!visit[n_i][n_j] && arr[n_i][n_j] == 1) {
                        count++;
                        temp[n_i][n_j] = 0;
                        visit[n_i][n_j] = true;
                    } else if(!visit[n_i][n_j] && arr[n_i][n_j] == 0){
                        q.offer(new int[]{n_i, n_j});
                        visit[n_i][n_j] = true;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++)
            System.arraycopy(temp[i], 0, arr[i], 0, temp[i].length);

        return count;
    }
}
