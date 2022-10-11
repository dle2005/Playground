package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); // 건물의 개수
            int K = Integer.parseInt(st.nextToken()); // 건설 순서 규칙

            int[] time = new int[N+1]; // 건설에 걸리는 시간
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++)
                time[j] = Integer.parseInt(st.nextToken());

            List<Integer>[] list = new List[N+1]; // 인접리스트
            for(int j = 0; j <= N; j++)
                list[j] = new ArrayList<>();
            int[] degree = new int[N + 1];

            for(int j = 0; j < K; j++) { // 인접리스트 입력
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                degree[b]++;
            }

            int W = Integer.parseInt(br.readLine()); // 목표 건물

            Queue<Integer> queue = new LinkedList<>();
            int[] dp = new int[N+1];

            for(int j = 1; j <= N; j++) {
                dp[j] = time[j]; // dp 초기화

                if(degree[j] == 0) // 시작점 큐에 추가
                    queue.offer(j);
            }

            while(!queue.isEmpty()) { // 출발 지점 list에 저장
                int q = queue.poll();

                for(int j : list[q]) {
                    dp[j] = Math.max(dp[j], dp[q] + time[j]);
                    degree[j]--;

                    if(degree[j] == 0) // 차수 0을 다시 큐에 추가
                        queue.offer(j);
                }
            }

            System.out.println(dp[W]);
        }
    }
}
