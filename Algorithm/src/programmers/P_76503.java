package programmers;

import java.util.ArrayList;
import java.util.List;

public class P_76503 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-5, 0, 2, 1, 2}, new int[][]{{0,1},{3,4},{2,3},{0,3}}));
    }
    public static List<Integer>[] list;
    public static boolean[] visit;
    public static long[] weight;
    public static long answer;

    public static long solution(int[] a, int[][] edges) {
        long sum = 0;
        list = new ArrayList[a.length];
        visit = new boolean[a.length];
        weight = new long[a.length];

        for (int i = 0; i < a.length; i++) {
            list[i] = new ArrayList<>();
            weight[i] = a[i];
            sum += a[i];
        }

        if(sum != 0) return -1;

        for (int i = 0; i < edges.length; i++) {
            int ab = edges[i][0];
            int ba = edges[i][1];

            list[ab].add(ba);
            list[ba].add(ab);
        }

        dfs(0);

        return answer;
    }

    public static long dfs(int parent) {
        visit[parent] = true;

        for (int i = 0; i < list[parent].size(); i++) {
            int child = list[parent].get(i);
            if (!visit[child])
                weight[parent] += dfs(child);
        }

        answer += Math.abs(weight[parent]);
        return weight[parent];
    }
}
