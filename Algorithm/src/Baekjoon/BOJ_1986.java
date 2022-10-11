package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] chess = new int[n+1][m+1]; // 체스판

        List<int []> Queens = new LinkedList<>();
        List<int[]> Knights = new LinkedList<>();

        st = new StringTokenizer(br.readLine(), " ");
        int Q = Integer.parseInt(st.nextToken());
        for(int i = 0; i < Q; i++) {
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            chess[y][x] = 1;
            Queens.add(new int[]{y, x});
        }

        st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        for(int i = 0; i < K; i++) {
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            chess[y][x] = 1;
            Knights.add(new int[]{y, x});
        }

        st = new StringTokenizer(br.readLine(), " ");
        int P = Integer.parseInt(st.nextToken());
        for(int i = 0; i < P; i++) {
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            chess[y][x] = 1;
        }

        for(int[] Queen : Queens) {
            int y = Queen[0];
            int x = Queen[1];

            // 가로
            for(int i = x-1; i > 0; i--) {
                if(chess[y][i] == 1)
                    break;
                chess[y][i] = 2;
            }
            for(int i = x+1; i <= m; i++) {
                if(chess[y][i] == 1)
                    break;
                chess[y][i] = 2;
            }

            // 세로
            for(int i = y-1; i > 0; i--) {
                if(chess[i][x] == 1)
                    break;
                chess[i][x] = 2;
            }
            for(int i = y+1; i <= n; i++) {
                if(chess[i][x] == 1)
                    break;
                chess[i][x] = 2;
            }

            // 대각선
            for(int i = y+1, j = x+1; i <= n && j <= m; i++, j++) { // 우측상단
                if(chess[i][j] == 1)
                    break;
                chess[i][j] = 2;
            }
            for(int i = y-1, j = x+1; 0 < i && j <= m; i--, j++) { // 우측하단
                if(chess[i][j] == 1)
                    break;
                chess[i][j] = 2;
            }
            for(int i = y+1, j = x-1; i <= n && 0 < j; i++, j--) { // 좌측상단
                if(chess[i][j] == 1)
                    break;
                chess[i][j] = 2;
            }
            for(int i = y-1, j = x-1; 0 < i && 0 < j; i--, j--) { // 좌측 하단
                if(chess[i][j] == 1)
                    break;
                chess[i][j] = 2;
            }
        }

        int[] dy = {1, -1, -2, -2, -1,  1,  2, 2};
        int[] dx = {2,  2,  1, -1, -2, -2, -1, 1};

        for(int[] Knight : Knights) {
            int y = Knight[0];
            int x = Knight[1];

            for(int i = 0; i < 8; i++) {
                int yy = y + dy[i];
                int xx = x + dx[i];

                if(0 < yy && yy <= n && 0 < xx && xx <= m) {
                    if(chess[yy][xx] != 1)
                        chess[yy][xx] = 2;
                }
            }
        }

        int count = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(chess[i][j] == 0)
                    count++;
            }
        }

        System.out.println(count);
    }
}
