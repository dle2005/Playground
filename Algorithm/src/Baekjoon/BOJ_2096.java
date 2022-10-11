package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] min = new int[N + 1][3];
        int[][] max = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            min[i][0] = arr[i][0] + Math.min(min[i - 1][0], min[i - 1][1]);
            max[i][0] = arr[i][0] + Math.max(max[i - 1][0], max[i - 1][1]);

            min[i][1] = arr[i][1] + Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2]));
            max[i][1] = arr[i][1] + Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2]));

            min[i][2] = arr[i][2] + Math.min(min[i - 1][1], min[i - 1][2]);
            max[i][2] = arr[i][2] + Math.max(max[i - 1][1], max[i - 1][2]);
        }

        System.out.println(Math.max(max[N][0], Math.max(max[N][1], max[N][2]))
                + " " + Math.min(min[N][0], Math.min(min[N][1], min[N][2])));
    }
}
