package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] in_degree = new int[N + 1];
        List<Integer>[] list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B);
            in_degree[B]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (in_degree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            answer.append(cur).append(" ");

            for (int next : list[cur]) {
                in_degree[next]--;

                if (in_degree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        System.out.println(answer);
    }
}
