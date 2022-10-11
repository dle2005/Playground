package Baekjoon;

import java.util.*;

public class BOJ_1260 {
    public static List<Integer>[] list;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        list = new LinkedList[N + 1];
        for(int i = 0; i <= N; i++)
            list[i] = new LinkedList<>();
        visit = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 0; i <= N; i++)
            Collections.sort(list[i]);

        dfs(N, V, 1);
        System.out.println(sb);

        visit = new boolean[N + 1];
        sb = new StringBuilder();
        bfs(V);

        System.out.println(sb);

    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visit[v] = true;

        while(!queue.isEmpty()) {
            int q = queue.poll();
            sb.append(q).append(" ");

            for(int i : list[q]) {
                if(!visit[i]) {
                    visit[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    public static void dfs(int N, int v, int depth) {
        visit[v] = true;
        sb.append(v).append(" ");

        for(int i : list[v]) {
            if(!visit[i]) {
                dfs(N, i, depth + 1);
            }
        }
    }
}
