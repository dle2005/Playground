package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3584 {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            parent = new int[N + 1];

            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                parent[b] = a;
            }

            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            int v1_depth = dfs(v1);
            int v2_depth = dfs(v2);


            same_parent(v1, v1_depth, v2, v2_depth);
        }
    }

    public static int dfs(int node) {
        int depth = 0;
        int cur = node;

        while (cur != 0) {
            depth++;
            cur = parent[cur];
        }

        return depth - 1;
    }

    public static void same_parent(int v1, int v1_depth, int v2, int v2_depth) {
        if (v1_depth > v2_depth) {
            while (v1_depth != v2_depth) {
                v1_depth--;
                v1 = parent[v1];
            }
        } else {
            while (v1_depth != v2_depth) {
                v2_depth--;
                v2 = parent[v2];
            }
        }

        while (v1 != v2) {
            v1 = parent[v1];
            v2 = parent[v2];
        }

        System.out.println(v1);
    }
}
