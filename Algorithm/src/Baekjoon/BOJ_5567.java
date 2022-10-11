package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 동기의 수
        int m = Integer.parseInt(br.readLine()); // 리스트의 길이

        List<Integer>[] list = new List[n+1]; // 인접 리스트 사용
        for(int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b); // 비방향 그래프
            list[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>(); // BFS 탐색
        boolean[] visit = new boolean[n+1]; // 사이클 방지 및 동기의 수 판별용도
        visit[1] = true; // 상근이는 검사 생략

        for(int i : list[1]) { // 상근이의 친구 검사
            visit[i] = true;
            queue.offer(i); // 친구의 친구를 검사하기 위해 큐에 추가
        }

        while (!queue.isEmpty()) {
            int q = queue.poll(); // 상근이의 친구

            for(int i : list[q]) { // 친구의 친구 검사
                if(!visit[i])
                    visit[i] = true;
            }
        }

        int sum = 0;
        for(int i = 2; i <= n; i++) { // 상근이를 제외한 친구 검사
            if(visit[i]) sum++; // 참인경우 초대
        }

        System.out.println(sum);
    }
}
