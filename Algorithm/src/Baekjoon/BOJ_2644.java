package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer>[] list = new List[n + 1];
        for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();
        boolean[] visit = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visit[start] = true;

        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int cur = q[0];
            int cnt = q[1];

            if (cur == dest) {
                System.out.println(cnt);
                return;
            }

            for (int next : list[cur]) {
                if (!visit[next]) {
                    visit[next] = true;
                    queue.offer(new int[]{next, cnt + 1});
                }
            }
        }

        System.out.println(-1);
    }
}
