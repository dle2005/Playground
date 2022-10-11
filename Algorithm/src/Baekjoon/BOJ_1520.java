package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1520 {
    public static int M, N;
    public static int[][] map, dp;

    public static int[] di = {1, 0, -1, 0};
    public static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    public static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) return 1;

        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;

        for (int k = 0; k < 4; k++) {
            int i = di[k] + x;
            int j = dj[k] + y;

            if (i < 0 || j < 0 || i >= M || j >= N) continue;

            if (map[i][j] < map[x][y]) dp[x][y] += dfs(i, j);
        }

        return dp[x][y];
    }
}
