package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_5668 {
    public static int n, k;
    public static int[] inputs;
    public static boolean[] visit;
    public static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        inputs = new int[n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++)
            inputs[i] = Integer.parseInt(br.readLine());

        dfs(0, "");

        System.out.println(set.size());
    }

    public static void dfs(int depth, String s) {
        if (depth == k) {
            set.add(s);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, s + inputs[i]);
                visit[i] = false;
            }
        }
    }
}
