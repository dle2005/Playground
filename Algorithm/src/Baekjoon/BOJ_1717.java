package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for(int i = 0; i <= n; i++) parent[i] = i;

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (operation == 1) {
                if (check(a, b)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            } else union(a, b);
        }

        System.out.println(sb);
    }

    public static int find(int node) {
        if (node == parent[node]) return node;
        else return parent[node] = find(parent[node]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) parent[b] = a;
    }

    public static boolean check(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return true;
        else return false;
     }
}
