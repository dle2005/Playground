package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class P_81302 {
    public static void main(String[] args) {

    }

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            char[][] map = getMap(places[i]);

            answer[i] = isPromise(map) ? 1 : 0;
        }

        return answer;
    }

    public static boolean isPromise(char[][] map) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 'P' && !check(map, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean check(char[][] map, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

            if (map[nx][ny] == 'P') return false;

            if (map[nx][ny] == 'O') queue.add(new int[]{nx, ny});
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (nx == i && ny == j) continue;

                if (map[nx][ny] == 'P') return false;
            }
        }

        return true;
    }

    public static char[][] getMap(String[] place) {
        char[][] map = new char[5][5];

        for (int i = 0; i < 5; i++) {
            map[i] = place[i].toCharArray();
        }

        return map;
    }
}
