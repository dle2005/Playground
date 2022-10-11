package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int N2 = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        int i = 0, j = 0, dir = 0, dirCnt = 1, moveCnt = 0, num = N * N + 1;
        int x = 0, y = 0;

        int[] di = {1, 0, -1, 0};
        int[] dj = {0, 1, 0, -1};

        while (num-- > 1) {
            map[i][j] = num;

            if (map[i][j] == N2) {
                x = i + 1;
                y = j + 1;
            }

            moveCnt++;

            if (moveCnt == N) {
                moveCnt = 0;
                dirCnt++;
                dir = (dir + 1) % 4;

                if (dirCnt % 2 == 0) N--;
            }

            i += di[dir];
            j += dj[dir];
        }

        StringBuilder sb = new StringBuilder();
        for (int[] r : map) {
            for (int c : r) sb.append(c).append(" ");
            sb.append("\n");
        }
        sb.append(x).append(" ").append(y);

        System.out.println(sb);
    }
}
