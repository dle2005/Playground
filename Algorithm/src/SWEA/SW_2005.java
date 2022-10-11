package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_2005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int index = 0;

        while (index++ < T) {
            sb.append("#" + index + "\n");

            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0) arr[i][j] = 1;
                    else arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];

                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
