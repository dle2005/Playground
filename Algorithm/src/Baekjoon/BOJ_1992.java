package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {
    public static int N;
    public static int[][] map;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++)
                map[i][j] = s.charAt(j) - '0';
        }

        recursion(0, 0, N);

        System.out.println(sb);
    }

    public static void recursion(int x, int y, int size) {
        if (!check(x, y, size)) {
            sb.append("(");

            int s = size / 2;
            recursion(x, y, s);
            recursion(x, y + s, s);
            recursion(x + s, y, s);
            recursion(x + s, y + s, s);

            sb.append(")");
        }
    }

    public static boolean check(int x, int y, int size) {
        int n = map[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != n) return false;
            }
        }

        sb.append(n);
        return true;
    }
}
