package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468 {
    public static int N, max;
    public static int[][] map;
    public static boolean[][] visit;

    public static int[] di = {0, 1, 0, -1};
    public static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                max = Math.max(max, n);
                map[i][j] = n;
            }
        }

        int answer = 0;

        for (int i = 0; i <= max; i++)
            answer = Math.max(answer, flooding(i));

        System.out.println(answer);
    }

    public static void dfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] q = queue.poll();

            for (int k = 0; k < 4; k++) {
                int i = q[0] + di[k];
                int j = q[1] + dj[k];

                if(i < 0 || j < 0 || i >= N || j >= N) continue;

                if (!visit[i][j] && map[i][j] != 999) {
                    visit[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }

    }

    public static int getArea() {
        int cnt = 0;
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && map[i][j] != 999) {
                    visit[i][j] = true;
                    cnt++;
                    dfs(i, j);
                }
            }
        }

        return cnt;
    }

    public static int flooding(int height) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] <= height)
                    map[i][j] = 999;
            }
        }

        return getArea();
    }
}
