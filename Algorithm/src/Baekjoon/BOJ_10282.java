package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10282 {
    public static class Node implements Comparable<Node> {
        int computer;
        int second;

        public Node(int computer, int second) {
            this.computer = computer;
            this.second = second;
        }

        @Override
        public int compareTo(Node o) {
            return this.second - o.second;
        }
    }

    public static List<Node>[] list;
    public static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list = new List[n + 1];
            distance = new int[n + 1];
            
            for (int i = 0; i <= n; i++) {
                list[i] = new ArrayList<>();
                distance[i] = Integer.MAX_VALUE;
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list[b].add(new Node(a, s));
            }

            int[] result = dijkstra(c);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }

        System.out.println(sb);
    }

    public static int[] dijkstra(int c) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(c, 0));

        distance[c] = 0;

        int cnt = 0, time = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (distance[cur.computer] < cur.second) continue;

            for (Node next : list[cur.computer]) {
                if (distance[next.computer] > cur.second + next.second) {

                    distance[next.computer] = cur.second + next.second;
                    pq.add(new Node(next.computer, cur.second + next.second));
                }
            }
        }

        for (int s : distance) {
            if (s != Integer.MAX_VALUE) {
                cnt++;
                time = Math.max(time, s);
            }
        }

        return new int[]{cnt, time};
    }
}
