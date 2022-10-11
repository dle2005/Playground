package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085 {
    public static int N, answer;
    public static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                char temp = map[i][j-1];
                map[i][j-1] = map[i][j];
                map[i][j] = temp;

                check();

                temp = map[i][j-1];
                map[i][j-1] = map[i][j];
                map[i][j] = temp;
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char temp = map[i-1][j];
                map[i-1][j] = map[i][j];
                map[i][j] = temp;

                check();

                temp = map[i-1][j];
                map[i-1][j] = map[i][j];
                map[i][j] = temp;
            }
        }

        System.out.println(answer);
    }

    public static void check() {
        for (int i = 0; i < N; i++) {
            int cnt = 1;

            for (int j = 1; j < N; j++) {
                if(map[i][j] == map[i][j-1]) cnt++;
                else cnt = 1;
                answer = Math.max(answer, cnt);
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 1;

            for (int j = 1; j < N; j++) {
                if(map[j][i] == map[j-1][i]) cnt++;
                else cnt = 1;
                answer = Math.max(answer, cnt);
            }
        }
    }
}
