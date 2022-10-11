package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class P_1844 {
    public static void main(String[] args) {

    }
    public int solution(int[][] maps) {
        int answer = -1;

        int n = maps.length;
        int m = maps[0].length;

        int[] di = {1, 0, -1, 0};
        int[] dj = {0, 1, 0, -1};

        boolean[][] visit = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, 1});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == n - 1 && cur[1] == m - 1) {
                answer = cur[2];
                break;
            }

            for (int k = 0; k < 4; k++) {
                int i = cur[0] + di[k];
                int j = cur[1] + dj[k];

                if (i < 0 || j < 0 || i >= n || j >= m) continue;
                if (maps[i][j] == 0) continue;
                if (visit[i][j]) continue;

                visit[i][j] = true;
                queue.offer(new int[]{i, j, cur[2] + 1});
            }
        }

        return answer;
    }
}
