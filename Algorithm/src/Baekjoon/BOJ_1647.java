package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1647 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node>[] list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            // 양방향으로 마을을 길로 연결
            list[A].add(new Node(B, C));
            list[B].add(new Node(A, C));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        boolean[] visit = new boolean[N + 1];
        List<Node> mst = new ArrayList<>();

        // MST
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // 이미 방문한 마을은 최소 비용으로 방문했음
            if (visit[cur.dest]) continue;
            visit[cur.dest] = true;
            mst.add(cur); //

            // 현재 마을에서 갈 수 있는 모든 마을을 추가
            for (Node next : list[cur.dest]) {
                pq.add(next);
            }
        }

        int answer = 0, max = 0;

        // 가장 긴 길을 제외하면
        // 두 개의 분리된 마을을 최소한으로 분할할 수 있음
        for (Node n : mst) {
            answer += n.dist;

            max = Math.max(max, n.dist);
        }

        System.out.println(answer - max);
    }

    public static class Node implements Comparable<Node>{
        int dest, dist;

        public Node(int dest, int dist) {
            this.dest = dest;
            this.dist = dist;
        }


        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}
