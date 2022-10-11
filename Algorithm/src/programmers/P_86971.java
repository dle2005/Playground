package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_86971 {

    class Solution {
        public List<Integer>[] list;

        public int solution(int n, int[][] wires) {
            int answer = 100;

            list = new List[n + 1];
            for (int i = 0; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            for (int[] wire : wires) {
                list[wire[0]].add(wire[1]);
                list[wire[1]].add(wire[0]);
            }

            for (int[] wire : wires) {
                int n1 = bfs(wire[0], wire[1], n);
                int n2 = bfs(wire[1], wire[0], n);

                answer = Math.min(answer, Math.abs(n1 - n2));
            }

            return answer;
        }

        public int bfs(int v1, int v2, int n) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visit = new boolean[n + 1];

            int cnt = 0;

            queue.add(v1);
            visit[v1] = true;

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                cnt++;

                for (int next : list[cur]) {
                    if (next != v2 && !visit[next]) {
                        queue.add(next);
                        visit[next] = true;
                    }
                }
            }

            return cnt;
        }
    }
}
