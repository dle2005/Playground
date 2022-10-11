package programmers;

public class P_77485 {
    public static void main(String[] args) {
        solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
        solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}});
        solution(100, 97, new int[][]{{1, 1, 100, 97}});
    }
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] grid = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = i * columns + j + 1;
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1, y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1, y2 = queries[i][3] - 1;

            int min = grid[x1][y1];
            int temp = grid[x1][y1];

            int x = x1 + dx[0], y = y1 + dy[0], d = 0;
            grid[x1][y1] = grid[x][y];

            while (x != x1 || y != y1) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < x1 || ny < y1 || nx > x2 || ny > y2) {
                    d = (d + 1) % 4;
                    nx = x + dx[d];
                    ny = y + dy[d];
                }

                grid[x][y] = grid[nx][ny];
                min = Math.min(min, grid[x][y]);

                x = nx;
                y = ny;
            }

            grid[x1][y1 + 1] = temp;
            answer[i] = min;
        }

        return answer;
    }
}
