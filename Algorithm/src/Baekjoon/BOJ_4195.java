package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_4195 {
    public static int[] parent, level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());

            parent = new int[F * 2];
            level = new int[F * 2];

            for (int i = 0; i < F * 2; i++) {
                parent[i] = i;
                level[i] = 1;
            }

            Map<String, Integer> map = new HashMap<>();

            int index = 0;

            while (F-- > 0) {
                String[] friends = br.readLine().split(" ");

                map.put(friends[0], map.getOrDefault(friends[0], index++));
                map.put(friends[1], map.getOrDefault(friends[1], index++));

                sb.append(union(map.get(friends[0]), map.get(friends[1]))).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static int find(int node) {
        if (parent[node] == node) return node;
        else return parent[node] = find(parent[node]);
    }

    public static int union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
            level[a] += level[b];
        }

        return level[a];
    }
}
