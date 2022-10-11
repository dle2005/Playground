package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로

        int size = Math.min(N, M); // 최대로 만들 수 있는 정사각형 크기
        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++)
                arr[i][j] = s.charAt(j) - '0';
        }

        for(int k = size-1; k >= 0; k--) {
            for(int i = 0; i < N-k; i++) {
                for(int j = 0; j < M-k; j++) {
                    if(i + k < N && j + k < M) {
                        if(arr[i][j] == arr[i][j+k]
                            && arr[i][j] == arr[i+k][j]
                            && arr[i][j] == arr[i+k][j+k]
                        ) {
                            System.out.println((k + 1) * (k + 1));
                            return;
                        }
                    }
                }
            }
        }


    }
}
