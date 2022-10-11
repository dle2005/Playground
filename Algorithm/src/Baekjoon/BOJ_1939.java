package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1939 {
    public static class Node {
        int dest;
        int weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static int N, M, start, dest;

    public static List<Node>[] list;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 섬의 수
        M = Integer.parseInt(st.nextToken()); // 다리의 수

        list = new List[N + 1];
        for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, weight));
            list[b].add(new Node(a, weight));
        }

        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        int answer = 0;
        int low = 0, high = 1000000001;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (bfs(mid)) {
                answer = Math.max(answer, mid);
                low = mid + 1;
            }
            else high = mid - 1;
        }

        System.out.println(answer);
    }

    public static boolean bfs(int weight) {
        visit = new boolean[N + 1]; visit[start] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node q = queue.poll();

            if (q.dest == dest)
                return true;

            for (Node n : list[q.dest]) {
                if (!visit[n.dest] && n.weight >= weight) {
                    visit[n.dest] = true;
                    queue.offer(n);
                }
            }
        }

        return false;
    }
}
