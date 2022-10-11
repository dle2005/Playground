package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1987 {
    public static char[][] arr;
    public static boolean[] visit;
    public static int max_move = 0, R, C;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] st = br.readLine().split("\\s");
        R = Integer.parseInt(st[0]);
        C = Integer.parseInt(st[1]);

        arr = new char[R][C];
        visit = new boolean[26];

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++)
                arr[i][j] = s.charAt(j);
        }

        dfs(0, 0, 1);

        sb.append(max_move).append("\n");
        System.out.println(sb);
    }

    public static void dfs(int y, int x, int depth) {
        visit[arr[y][x] - 'A'] = true;

        for(int i = 0; i < 4; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];

            if(0 <= yy && yy < R && 0 <= xx && xx < C) {
                if (!visit[arr[yy][xx] - 'A'])
                    dfs(yy, xx, depth + 1);
            }
        }

        visit[arr[y][x] - 'A'] = false;
        max_move = Math.max(max_move, depth);
    }
}
