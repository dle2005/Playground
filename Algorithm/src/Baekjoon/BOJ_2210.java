package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2210 {
    public static int[][] map;
    public static int answer;
    public static Set<String> set = new HashSet<>();

    public static int[] di = {0, 1, 0, -1};
    public static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                dfs(i, j, 0, String.valueOf(map[i][j]));
        }

        System.out.println(set.size());
    }

    public static void dfs(int i, int j, int cnt, String s) {
        if (cnt == 5) {
            set.add(s);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int ii = i + di[k];
            int jj = j + dj[k];

            if (ii < 0 || jj < 0 || ii >= 5 || jj >= 5) continue;

            dfs(ii, jj, cnt + 1, s + map[ii][jj]);
        }
    }
}
