package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    public static int[][] arr, count;
    public static boolean[][] visit;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        count = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++)
                arr[i][j] = s.charAt(j) - 48;
        }

        bfs();

        System.out.println(count[N-1][M-1] + 1);
    }

    static void bfs() {
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{0,0});

        while(!q.isEmpty()) {
            int[] top = q.poll();
            int i = top[0], j = top[1];

            if(!visit[i][j]) {
                visit[i][j] = true;

                if(i < N-1 && !visit[i+1][j] && arr[i+1][j] != 0) {
                    q.offer(new int[]{i + 1, j});
                    count[i+1][j] = count[i][j] +1;
                }
                if(0 < i && !visit[i-1][j] && arr[i-1][j] != 0) {
                    q.offer(new int[]{i - 1, j});
                    count[i-1][j] = count[i][j] +1;
                }
                if(j < M-1 && !visit[i][j+1] && arr[i][j+1] != 0) {
                    q.offer(new int[]{i, j + 1});
                    count[i][j+1] = count[i][j] +1;
                }
                if(0 < j && !visit[i][j-1] && arr[i][j-1] != 0) {
                    q.offer(new int[]{i, j - 1});
                    count[i][j-1] = count[i][j] +1;
                }
            }
        }
    }
}
