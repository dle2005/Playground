package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10830 {
    public static int N;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] answer = pow(arr, B);

        StringBuilder sb = new StringBuilder();
        for (int[] i : answer) {
            for (int j : i) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int[][] pow(int[][] a, long e) {
        if (e == 1) {
            return a;
        }

        int[][] temp = pow(a, e / 2);
        temp = mul(temp, temp);

        if (e % 2 == 0) {
            return temp;
        } else {
            return mul(temp, arr);
        }
    }

    public static int[][] mul(int[][] arr1, int[][] arr2) {
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    temp[i][j] += arr1[i][k] * arr2[k][j];
                    temp[i][j] %= 1000;
                }
            }
        }

        return temp;
    }
}
