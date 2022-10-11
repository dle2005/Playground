package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1162 {

    public static class Node implements Comparable<Node> {
        int dest;
        int distance;
        int cnt;

        public Node(int dest, int distance, int cnt) {
            this.dest = dest;
            this.distance = distance;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static int K;
    public static List<Node>[] list;
    public static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        list = new List[N + 1];
        dist = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, d, 0));
            list[b].add(new Node(a, d, 0));
        }

        dijkstra();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= K; i++)
            answer = Math.min(answer, dist[N][i]);

        System.out.println(answer);
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,  dist[1][0] = 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.dest][cur.cnt] < cur.distance) continue;

            for (Node next : list[cur.dest]) {
                int dest = next.dest;
                int distance = next.distance;

                if (dist[dest][cur.cnt] > distance) {
                    dist[dest][cur.cnt] = distance;
                    pq.add(new Node(dest, distance, cur.cnt));
                }

                if (cur.cnt < K && dist[dest][cur.cnt + 1] > cur.distance) {
                    dist[dest][cur.cnt + 1] = cur.distance;
                    pq.add(new Node(dest, cur.distance, cur.cnt + 1));
                }
            }
        }
    }
}
