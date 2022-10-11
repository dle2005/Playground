package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1240 {
    public static class Node implements Comparable<Node> {
        int dest;
        int distance;

        public Node(int dest, int distance) {
            this.dest = dest;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static List<Node>[] list;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new List[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, dis));
            list[b].add(new Node(a, dis));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            visit = new boolean[N + 1];
            visit[start] = true;
            sb.append(search(start, dest)).append("\n");
        }

        System.out.println(sb);
    }

    public static int search(int start, int dest) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.dest == dest) {
                return cur.distance;
            }

            for (Node next : list[cur.dest]) {
                if (!visit[next.dest]) {
                    pq.offer(new Node(next.dest, cur.distance + next.distance));
                    visit[next.dest] = true;
                }
            }
        }

        return -1;
    }
}
