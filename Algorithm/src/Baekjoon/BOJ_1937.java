package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1937 {
    public static int n, result;
    public static int[][] map, dp;

    public static int[] di = {1, 0, -1, 0};
    public static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1) dfs(i, j);
            }
        }

        System.out.println(result);
    }

    public static int dfs(int x, int y) {
        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 1;

        int max = 0;
        for (int k = 0; k < 4; k++) {
            int i = x + di[k];
            int j = y + dj[k];

            if (i < 0 || j < 0 || i >= n || j >= n) continue;

            if (map[x][y] < map[i][j]) {
                max = Math.max(max, dfs(i, j));
            }
        }

        dp[x][y] += max;
        result = Math.max(result, dp[x][y]);
        return dp[x][y];
    }
}
