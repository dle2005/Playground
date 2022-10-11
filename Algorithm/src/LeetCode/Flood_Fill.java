package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Flood_Fill {
    public static void main(String[] args) {
        Arrays.stream(floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2))
                .forEach(ints -> System.out.println(Arrays.toString(Arrays.stream(ints).toArray())));

        Arrays.stream(floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 0))
                .forEach(ints -> System.out.println(Arrays.toString(Arrays.stream(ints).toArray())));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        final int[] dx = {1, 0, -1, 0};
        final int[] dy = {0, 1, 0, -1};

        final int r = image.length, c = image[0].length, prevColor = image[sr][sc];

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[r][c];

        queue.add(new int[]{sr, sc});
        visit[sr][sc] = true;
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (visit[nx][ny] || image[nx][ny] != prevColor) continue;

                queue.add(new int[]{nx, ny});
                visit[nx][ny] = true;
                image[nx][ny] = color;
            }
        }

        return image;
    }
}
