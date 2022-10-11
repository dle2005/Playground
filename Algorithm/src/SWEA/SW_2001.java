package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2001 {
    public static int N, M;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int index = 0;

        while (index++ < T) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            int max = 0;

            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++)
                    max = Math.max(max, calc(i, j));
            }

            sb.append("#" + index + " " + max + "\n");
        }

        System.out.println(sb);
    }

    public static int calc(int x, int y) {
        int sum = 0;

        for (int i = x; i < x + M; i++) {
            for (int j = y; j < y + M; j++)
                sum += map[i][j];
        }

        return sum;
    }
}
