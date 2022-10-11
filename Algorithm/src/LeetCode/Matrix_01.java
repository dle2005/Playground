package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix_01 {
    public static void main(String[] args) {
        Arrays.stream(updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}))
                .forEach(ints -> System.out.println(Arrays.toString(Arrays.stream(ints).toArray())));

        Arrays.stream(updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}))
                .forEach(ints -> System.out.println(Arrays.toString(Arrays.stream(ints).toArray())));
    }

    public static int[][] updateMatrix(int[][] mat) {
        final int n = mat.length, m = mat[0].length;
        final int[] dx = {1, 0, -1, 0};
        final int[] dy = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];

        addZeros(mat, queue, visit);

        int[][] output = new int[n][m];
        int cnt = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int idx = 0; idx < size; idx++) {
                int[] cur = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (visit[nx][ny]) continue;

                    queue.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                    output[nx][ny] = cnt;
                }
            }

            cnt++;
        }

        return output;
    }

    private static void addZeros(int[][] mat, Queue<int[]> queue, boolean[][] visit) {
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 0) {
                    queue.add(new int[]{r, c});
                    visit[r][c] = true;
                }
            }
        }
    }
}
