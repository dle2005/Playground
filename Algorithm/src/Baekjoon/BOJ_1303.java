package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1303 {
    public static int N, M, w = 0, b = 0;
    public static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 가로의 크기
        M = Integer.parseInt(st.nextToken()); // 세로의 크기

        arr = new char[M][N]; // 전쟁터

        for(int i = 0; i < M; i++) { // 병사들 입력
            String s = br.readLine();
            for(int j = 0; j < N; j++)
                arr[i][j] = s.charAt(j);
        }

        bfs();

        System.out.println(w + " " + b);

    }

    public static void bfs() {
        Queue<int []> queue = new LinkedList<>();
        boolean[][] visit = new boolean[M][N];

        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                int cnt = 0;
                char c = arr[i][j]; // 어떤 병사인지 기록

                if(!visit[i][j]) { // 방문한적이 없으면
                    queue.offer(new int[]{i, j}); // 큐에 추가
                    visit[i][j] = true;

                    while (!queue.isEmpty()) { // BFS 탐색 시작
                        cnt++; // 병사의 수 증가
                        int[] q = queue.poll();

                        for(int k = 0; k < 4; k++) {
                            int ii = q[0] + di[k]; // 새로 탐색할 다음 좌표
                            int jj = q[1] + dj[k];

                            // 전쟁터를 벗어나는 경우는 생략
                            if(ii < 0 || ii >= M || jj < 0 || jj >= N) continue;
                            if(visit[ii][jj]) continue; // 이미 방문한 경우 생략
                            if(arr[ii][jj] != c) continue; // 같은 병사인 경우만 탐색

                            queue.offer(new int[]{ii, jj});
                            visit[ii][jj] = true;
                        }
                    }

                    if(c == 'W') w += cnt * cnt;
                    else b += cnt * cnt;
                }
            }
        }
    }
}
