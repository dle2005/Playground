package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
        }

        int[] answer = getSpace(N, map);

        System.out.println(answer[0] + " " + answer[1]);
    }

    public static int[] getSpace(int N, char[][] map) {
        int horizontal = 0, vertical = 0;

        for (int i = 0; i < N; i++) {
            int hSpaceCnt = 0, vSpaceCnt = 0;

            for (int j = 0; j < N; j++) {
                if (map[i][j] == '.') {
                    hSpaceCnt++;
                }
                if (map[j][i] == '.') {
                    vSpaceCnt++;
                }

                if (map[i][j] == 'X' || j == N - 1) {
                    if (hSpaceCnt >= 2) {
                        horizontal++;
                    }

                    hSpaceCnt = 0;
                }
                if (map[j][i] == 'X' || j == N - 1) {
                    if (vSpaceCnt >= 2) {
                        vertical++;
                    }

                    vSpaceCnt = 0;
                }
            }
        }

        return new int[]{horizontal, vertical};
    }
}
