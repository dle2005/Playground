package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197 {
    public static class Node implements Comparable<Node> {
        int dest; // 도착지
        int distance; // 거리

        public Node(int dest, int distance) {
            this.dest = dest;
            this.distance = distance;
        }

        public Node(Node n) {
            this.dest = n.dest;
            this.distance = n.distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수

        List<Node>[] list = new List[V+1]; // 인접리스트 저장용
        for(int i = 0; i <= V; i++)
            list[i] = new ArrayList<>();

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken()); // A번 정점
            int B = Integer.parseInt(st.nextToken()); // B번 정점
            int C = Integer.parseInt(st.nextToken()); // 가중치 C

            list[A].add(new Node(B, C)); // 양방향으로 저장
            list[B].add(new Node(A, C));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));

        boolean[] visit = new boolean[V+1]; // 사이클 방지용
        List<Node> MST = new ArrayList<>();

        while(!queue.isEmpty()) {
            Node q = queue.poll();

            if(visit[q.dest]) continue;
            visit[q.dest] = true;
            MST.add(new Node(q));

            for(Node n : list[q.dest])
                queue.add(new Node(n));
        }

        int sum = 0;
        for(Node n : MST)
            sum += n.distance;

        System.out.println(sum);
    }
}
