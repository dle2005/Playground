package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges {
    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        System.out.println(orangesRotting(new int[][]{{0, 2}}));
    }

    public static int orangesRotting(int[][] grid) {
        final int n = grid.length, m = grid[0].length;
        final int[] dx = {1, 0, -1, 0};
        final int[] dy = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];

        int ones = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1) {
                    ones++;
                } else if (grid[r][c] == 2){
                    queue.add(new int[]{r, c});
                    visit[r][c] = true;
                }
            }
        }

        if (ones == 0) {
            return 0;
        }

        int output = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int idx = 0; idx < size; idx++) {
                int[] cur = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (visit[nx][ny] || grid[nx][ny] != 1) continue;

                    queue.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                    ones--;

                    if (ones == 0) {
                        return output + 1;
                    }
                }
            }

            output++;
        }

        return -1;
    }
}
