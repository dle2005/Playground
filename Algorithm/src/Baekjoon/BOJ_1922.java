package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1922 {
    public static class Node implements Comparable<Node> {
        int dest; // 목적지
        int cost; // 연결 비용

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        public Node(Node n) {
            this.dest = n.dest;
            this.cost = n.cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine()); // 연결할 수 있는 선의 수

        List<Node>[] list = new List[N+1];
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) { // 각 컴퓨터를 연결하는데 드는 비용
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == b) continue; // a와 b가 같으면 불필요한 비용이 발생

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0)); // 시작점을 1로 설정

        boolean[] visit = new boolean[N+1]; // 방문한 노드는 다시 방문 하지 않음
        int total_cost = 0;

        while(!queue.isEmpty()) {
            Node q = queue.poll();

            // 우선순위 큐를 사용하기 때문에 모든 인접 노드들이 전부 추가가 된 다음
            // visit 검사를 해야 최소 비용으로 가능

            if(visit[q.dest]) continue;
            visit[q.dest] = true;
            total_cost += q.cost;

            // 우선 우선순위 큐에 인접 노드들을 전부 추가
            // 우선순위 큐가 알아서 갈 수 있는 최저 비용의 노드를 골라줌
            for(Node n : list[q.dest])
                queue.add(new Node(n));
        }

        System.out.println(total_cost);
    }
}
