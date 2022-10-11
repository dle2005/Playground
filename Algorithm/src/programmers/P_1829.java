package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class P_1829 {
    public static void main(String[] args) {
        System.out.println(solution(6, 4,
                new int[][]{{1, 1, 1, 0},
                            {1, 2, 2, 0},
                            {1, 0, 0, 1},
                            {0, 0, 0, 1},
                            {0, 0, 0, 3},
                            {0, 0, 0, 3}}));
    }

    static boolean[][] visit;

    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];

        visit = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visit[i][j] && picture[i][j] != 0) {
                    int cnt = bfs(i, j, m, n, picture);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                    numberOfArea++;
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }

    public static int bfs(int i, int j, int m, int n, int[][] picture) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visit[i][j] = true;
        int num = picture[i][j];

        int count = 1;

        while (!queue.isEmpty()) {
            int[] q = queue.poll();

            for(int k = 0; k < 4; k++) {
                int ii = q[0] + di[k];
                int jj = q[1] + dj[k];

                if(ii < 0 || jj < 0 || ii >= m || jj >= n) continue;
                if(picture[ii][jj] != num) continue;
                if(visit[ii][jj]) continue;

                queue.offer(new int[]{ii, jj});
                visit[ii][jj] = true;
                count++;
            }
        }

        return count;
    }
}
