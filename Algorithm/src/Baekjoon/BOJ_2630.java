package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
    public static int[][] arr;
    public static int white, blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        white = blue = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        dp(0,0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void dp(int x, int y, int n) {
        int start_point = arr[x][y];

        for(int i = x; i < x + n; i++) {
            for(int j = y; j < y + n; j++) {
                if(arr[i][j] != start_point) {
                    dp(x, y, n/2);
                    dp(x, y + n/2, n/2);
                    dp(x + n/2, y, n/2);
                    dp(x + n/2, y + n/2, n/2);

                    return;
                }
            }
        }



        if(start_point == 0) white++;
        else blue++;
    }
}
