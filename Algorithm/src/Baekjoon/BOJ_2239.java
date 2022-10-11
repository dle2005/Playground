package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BOJ_2239 {
    public static int[][] map = new int[9][9];
    public static List<Pos> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String t = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = t.charAt(j) - '0';

                if (map[i][j] == 0) list.add(new Pos(i, j));
            }
        }

        fill(0);
    }

    public static void fill(int index) {
        if (list.size() == index) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);

            System.exit(0);
        }

        int x = list.get(index).x;
        int y = list.get(index).y;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 9; i++) set.add(map[i][y]);
        for (int j = 0; j < 9; j++) set.add(map[x][j]);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                set.add(map[(x / 3) * 3 + i][(y / 3) * 3 + j]);
            }
        }

        for (int i = 1; i <= 9; i++) {
            if (!set.contains(i)) {
                map[x][y] = i;
                fill(index + 1);
                map[x][y] = 0;
            }
        }
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
