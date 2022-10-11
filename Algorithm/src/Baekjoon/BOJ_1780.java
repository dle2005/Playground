package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {
    public static int[][] arr;
    public static int zero = 0, one = 0, minus = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        divide_conquer(0,0, N);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }

    public static void divide_conquer(int y, int x, int N) {
        int start = arr[y][x];

        for(int i = y; i < y + N; i++) {
            for(int j = x; j < x + N; j++) {
                if(arr[i][j] != start) {

                    divide_conquer(y, x, N/3);
                    divide_conquer(y, x+N/3, N/3);
                    divide_conquer(y, x+N/3+N/3, N/3);
                    divide_conquer(y+N/3, x, N/3);
                    divide_conquer(y+N/3, x+N/3, N/3);
                    divide_conquer(y+N/3, x+N/3+N/3, N/3);
                    divide_conquer(y+N/3+N/3, x, N/3);
                    divide_conquer(y+N/3+N/3, x+N/3, N/3);
                    divide_conquer(y+N/3+N/3, x+N/3+N/3, N/3);

                    return;
                }
            }
        }

        if(start == 0) zero++;
        else if(start == 1) one++;
        else if(start == -1) minus++;
    }
}
