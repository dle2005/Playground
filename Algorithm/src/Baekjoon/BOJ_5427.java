package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427 {
    public static int w, h;
    public static char[][] map;
    public static boolean[][] visit;

    public static int[] di = {0, 1, 0, -1};
    public static int[] dj = {1, 0, -1, 0};

    public static Queue<Pos> sanggeun;
    public static Queue<Pos> fire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            visit = new boolean[h][w];

            sanggeun = new LinkedList<>();
            fire = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String t = br.readLine();
                for (int j = 0; j < w; j++) {
                    char c = t.charAt(j);

                    if (c == '@') {
                        sanggeun.add(new Pos(i, j));
                        visit[i][j] = true;
                    } else if (c == '*') {
                        fire.add(new Pos(i, j));
                    }

                    map[i][j] = c;
                }
            }

            int result = solve();
            if (result == -1) sb.append("IMPOSSIBLE").append("\n");
            else sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static int solve() {
        int cnt = 1;

        while (true) {
            spread();

            int result = move();

            if (result == 1) return cnt;
            else if (result == -1) return -1;

            cnt++;
        }
    }

    public static int move() {
        Queue<Pos> temp = new LinkedList<>();

        while (!sanggeun.isEmpty()) {
            Pos s = sanggeun.poll();

            for (int k = 0; k < 4; k++) {
                int i = s.x + di[k];
                int j = s.y + dj[k];

                if (i == -1 || j == -1 || i == h || j == w) return 1;
                if (map[i][j] == '#' || map[i][j] == '*') continue;
                if (visit[i][j]) continue;

                temp.add(new Pos(i, j));
                visit[i][j] = true;
            }
        }

        sanggeun = new LinkedList<>(temp);
        if (temp.size() == 0) return -1;
        else return 0;
    }

    public static void spread() {
        Queue<Pos> temp = new LinkedList<>();

        while (!fire.isEmpty()) {
            Pos f = fire.poll();

            for (int k = 0; k < 4; k++) {
                int i = f.x + di[k];
                int j = f.y + dj[k];

                if (i < 0 || j < 0 || i >= h || j >= w) continue;
                if (map[i][j] == '#' || map[i][j] == '*') continue;

                map[i][j] = '*';
                temp.add(new Pos(i, j));
            }
        }

        fire = new LinkedList<>(temp);
    }

    public static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
