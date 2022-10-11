package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][M + 1];
        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 1; m <= M; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder answer = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        for (int k = 1; k <= K; k++) {
            st = new StringTokenizer(br.readLine());
            answer.append(calculate(arr, Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.println(answer);
    }

    public static int calculate(int[][] arr, int i, int j, int x, int y) {
        int sum = 0;

        for (int n = i; n <= x; n++) {
            for (int m = j; m <= y; m++) {
                sum += arr[n][m];
            }
        }

        return sum;
    }
}
