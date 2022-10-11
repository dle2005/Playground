package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1238 {
    public static int N, M, X;

    public static List<Node>[] list;
    public static int[][] min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new List[N + 1];
        min = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList();
            Arrays.fill(min[i], Integer.MAX_VALUE);
            min[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            list[A].add(new Node(B, T));
        }

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, min[i][X] + min[X][i]);
        }
        System.out.println(answer);
    }

    public static void dijkstra(int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N + 1];

        pq.add(new Node(n, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visit[cur.dest]) continue;
            visit[cur.dest] = true;

            for (Node next : list[cur.dest]) {
                if (min[n][next.dest] > min[n][cur.dest] + next.dist) {
                    min[n][next.dest] = min[n][cur.dest] + next.dist;
                    pq.offer(new Node(next.dest, min[n][next.dest]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node>{
        int dest;
        int dist;

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
