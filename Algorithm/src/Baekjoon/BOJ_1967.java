package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1967 {
    public static class Node {
        int dest;
        int weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static List<Node>[] list;
    public static boolean[] visit;
    public static int start, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        list = new List[n + 1];
        for(int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, w));
            list[b].add(new Node(a, w));
        }

        visit = new boolean[n + 1];
        dfs(1, 0);

        visit = new boolean[n + 1];
        dfs(start, 0);

        System.out.println(answer);
    }

    public static void dfs(int node, int weight) {
        visit[node] = true;

        if(answer < weight) {
            answer = Math.max(answer, weight);
            start = node;
        }

        for (Node next : list[node]) {
            if (!visit[next.dest]) {
                dfs(next.dest, weight + next.weight);
            }
        }
    }
}
