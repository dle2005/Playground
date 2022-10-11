package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1107 {
    public static int N, M, diff;
    public static List<Integer> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) set.add(i);
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) set.remove(Integer.parseInt(st.nextToken()));
        }
        nums = new ArrayList<>(set);

        diff = Math.abs(N - 100);

        dfs(-1, 0);

        System.out.println(diff);
    }

    public static void dfs(int n, int len) {
        if (n != -1) diff = Math.min(diff, len + Math.abs(N - n));

        if (n > 1_000_000) return;

        for (int i = 0; i < nums.size(); i++) {
            if (n == 0 && nums.get(i) == 0) continue;
            if (n == -1) dfs(nums.get(i), len + 1);
            else dfs(n * 10 + nums.get(i), len + 1);
        }
    }
}
