package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589 {
    public static int R, C;
    public static int[][] map;
    public static boolean[][]visit;

    public static int[] di = {1, 0, -1, 0};
    public static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'L') list.add(new int[]{i, j});
            }
        }

        int max = 0;

        for (int[] l : list) max = Math.max(max, bfs(l[0], l[1]));

        System.out.println(max);
    }

    public static int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c, 0});

        visit = new boolean[R][C];
        visit[r][c] = true;

        int max = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            max = Math.max(max, cur[2]);

            for (int k = 0; k < 4; k++) {
                int i = cur[0] + di[k];
                int j = cur[1] + dj[k];

                if (i < 0 || j < 0 || i >= R || j >= C) continue;
                if (map[i][j] != 'L') continue;
                if (visit[i][j]) continue;

                visit[i][j] = true;
                queue.offer(new int[]{i, j, cur[2] + 1});
            }
        }

        return max;
    }
}
