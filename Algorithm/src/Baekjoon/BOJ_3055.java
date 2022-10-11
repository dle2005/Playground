package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055 {
    static class Pos {
        int x;
        int y;
        int cnt;

        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Queue<Pos> beaver = new LinkedList<>();
        Queue<int[]> water = new LinkedList<>();

        char[][] map = new char[R][C];
        boolean[][] visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'S') {
                    beaver.add(new Pos(i, j, 0));
                    visit[i][j] = true;
                }
                else if (map[i][j] == '*') water.add(new int[]{i, j});
            }
        }

        int[] di = {1, 0, -1, 0};
        int[] dj = {0, 1, 0, -1};
        int cnt = -1;

        while (!beaver.isEmpty()) {
            Pos cur = beaver.poll();

            if (map[cur.x][cur.y] == 'D') {
                System.out.println(cur.cnt);
                return;
            }

            if (cur.cnt != cnt) {
                Queue<int[]> temp = new LinkedList<>();
                while (!water.isEmpty()) {
                    int[] w = water.poll();

                    for (int k = 0; k < 4; k++) {
                        int i = w[0] + di[k];
                        int j = w[1] + dj[k];

                        if (i < 0 || j < 0 || i >= R || j >= C) continue;
                        if (map[i][j] != '.') continue;

                        map[i][j] = '*';
                        temp.add(new int[]{i, j});
                    }
                }
                water = temp;
                cnt++;
            }

            for (int k = 0; k < 4; k++) {
                int i = cur.x + di[k];
                int j = cur.y + dj[k];

                if (i < 0 || j < 0 || i >= R || j >= C) continue;
                if (map[i][j] != '.' && map[i][j] != 'D') continue;
                if (visit[i][j]) continue;

                visit[i][j] = true;
                beaver.add(new Pos(i, j, cur.cnt + 1));
            }
        }

        System.out.println("KAKTUS");
    }
}
