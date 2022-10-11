package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1504 {
    public static int N, E, v1, v2;
    public static List<Node>[] list;

    public static int[][] min;
    public static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new List[N + 1];
        min = new int[3][N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < 3; i++) {
            Arrays.fill(min[i], INF);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        min[0][1] = min[1][v1] = min[2][v2] = 0;

        dijkstra(1, 0);
        dijkstra(v1, 1);
        dijkstra(v2, 2);

        int answer = Math.min(
                min[0][v1] + min[1][v2] + min[2][N],
                min[0][v2] + min[2][v1] + min[1][N]
        );

        System.out.println(answer > INF ? -1 : answer);
    }

    public static void dijkstra(int v, int idx) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N + 1];

        pq.offer(new Node(v, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visit[cur.dest]) continue;
            visit[cur.dest] = true;

            for (Node next : list[cur.dest]) {
                if (min[idx][next.dest] > min[idx][cur.dest] + next.dist) {
                    min[idx][next.dest] = min[idx][cur.dest] + next.dist;

                    pq.offer(new Node(next.dest, min[idx][next.dest]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
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
