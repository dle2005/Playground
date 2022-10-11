package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Max_Area_of_Island {
    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));
        System.out.println(maxAreaOfIsland(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}}));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, getArea(grid, r, c));
                }
            }
        }

        return maxArea;
    }

    private static int getArea(int[][] grid, int r, int c) {
        final int n = grid.length, m = grid[0].length;
        final int[] dx = {1, 0, -1, 0};
        final int[] dy = {0, 1, 0, -1};

        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];

        queue.add(new int[]{r, c});
        visit[r][c] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visit[nx][ny] || grid[nx][ny] == 0) continue;

                cnt++;
                queue.add(new int[]{nx, ny});
                visit[nx][ny] = true;
            }
        }

        return cnt;
    }
}
