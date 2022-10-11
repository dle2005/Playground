package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 세로 길이
        int M = Integer.parseInt(st.nextToken()); // 가로 길이
        int K = Integer.parseInt(st.nextToken()); // 쓰레기의 개수

        int[][] arr = new int[N+1][M+1]; // 통로의 지도
        boolean[][] visit = new boolean[N+1][M+1];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
        }

        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};

        int max = 0; // 가장 큰 음식물의 크기

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                int count = 0;

                // 아직 방문전이며, 음식물을 경우 인접 음식물을 탐색
                if(!visit[i][j] && arr[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visit[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] q = queue.poll();
                        count++;

                        for(int k = 0; k < 4; k++) { // 주변 탐색
                            int ii = q[0] + di[k]; // 다음으로 방문할 위치
                            int jj = q[1] + dj[k];

                            // 통로를 벗어나는 경우 생략
                            if(ii < 1 || ii > N || jj < 1 || jj > M) continue;
                            if(arr[ii][jj] != 1) continue; // 오물인 아닌 경우 생략
                            if(visit[ii][jj]) continue; // 이미 방문한 곳은 다시 방문 하지 않음 

                            queue.offer(new int[]{ii, jj});
                            visit[ii][jj] = true;
                        }
                    }
                }

                max = Math.max(max, count);
            }
        }

        System.out.println(max);
    }
}
