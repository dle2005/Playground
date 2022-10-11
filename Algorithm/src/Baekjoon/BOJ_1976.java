package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 도시의 수
        int M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시들의 수

        List<Integer>[] list = new List[N+1]; // 연결 정보를 연결 리스트로 저장
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        for(int i = 1; i <= N; i++) { // 연결 정보 입력
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 1) // i 도시에서 j로 갈 수 있으면
                    list[i].add(j);
            }
        }

        int[] travel = new int[M]; // 여행 계획

        st = new StringTokenizer(br.readLine(), " "); // 여행 계획 입력
        for(int i = 0; i < M; i++)
            travel[i] = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[N+1]; // 방문 가능 여부 저장

        Queue<Integer> queue = new LinkedList<>();
        queue.add(travel[0]);

        while (!queue.isEmpty()) {
            int q = queue.poll();
            visit[q] = true;

            for(int i : list[q]) {
                if(!visit[i])
                    queue.add(i);
            }
        }

        for(int i : travel) {
            if(!visit[i]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static public void dfs() {

    }
}
