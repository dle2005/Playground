package Baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 {
    public static int N, landNum = 2, answer = Integer.MAX_VALUE;
    public static int[][] map, dist;
    public static Queue<Route> beach = new LinkedList<>();

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    setLandNum(i, j);
                }
            }
        }

        getDistance();

        System.out.println(answer);
    }

    public static void getDistance() {
        while (!beach.isEmpty()) {
            Route cur = beach.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if (map[nx][ny] != 0 && map[nx][ny] != cur.landNum) {
                    answer = Math.min(answer, dist[cur.x][cur.y] + dist[nx][ny]);
                } else if (map[nx][ny] == 0 && dist[nx][ny] == 0) {
                    map[nx][ny] = cur.landNum;
                    beach.add(new Route(nx, ny, cur.landNum));
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                }
            }
        }
    }

    public static void setLandNum(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        boolean[][] visit = new boolean[N][N];
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            map[cur.x][cur.y] = landNum;

            boolean isBeach = false;

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visit[nx][ny]) continue;

                if (map[nx][ny] == 0) {
                    isBeach = true;
                } else {
                    queue.add(new Point(nx, ny));
                    visit[nx][ny] = true;
                }
            }

            if (isBeach) {
                beach.add(new Route(cur.x, cur.y, map[cur.x][cur.y]));
            }
        }

        landNum++;
    }

    public static class Route {
        int x, y, landNum;

        public Route(int x, int y, int landNum) {
            this.x = x;
            this.y = y;
            this.landNum = landNum;
        }
    }

}
