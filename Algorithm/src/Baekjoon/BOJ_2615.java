package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615 {
    public static int[][] map = new int[21][21];
    public static boolean[][][] visit = new boolean[21][21][4];

    public static int[] dx = {0, 1, 1, -1};
    public static int[] dy = {1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 1; j <= 19; j++) {
            for (int i = 1; i <= 19; i++) {
                if (map[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        if (!visit[i][j][k] && isConcave(map[i][j], i, j, k)) {
                            System.out.println(map[i][j]);
                            System.out.println(i + " " + j);

                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    public static boolean isConcave(int n, int x, int y, int d) {
        visit[x][y][d] = true;

        int cnt = 1;

        while (true) {
            int nx = x + cnt * dx[d];
            int ny = y + cnt * dy[d];

            if (n != map[nx][ny]) {
                break;
            }

            visit[nx][ny][d] = true;

            if (++cnt > 5) {
                break;
            }
        }

        return cnt == 5;
    }
}
