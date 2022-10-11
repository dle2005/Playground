package programmers;

public class P_60059 {
    public static void main(String[] args) {
        System.out.println(solution(
                new int[][]{{0, 0, 0},
                            {1, 0, 0},
                            {0, 1, 1}},

                new int[][]{{1, 1, 1},
                            {1, 1, 0},
                            {1, 0, 1}}));
    }
    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;

        int[][] map = new int[lock.length * 3][lock.length * 3];
        for (int i = lock.length; i < lock.length * 2; i++) {
            for (int j = lock.length; j < lock.length * 2; j++)
                map[i][j] = lock[i - lock.length][j - lock.length];
        }

        for (int k = 0; k < 4; k++) {
            for (int i = 1 + lock.length - key.length; i < lock.length * 2; i++) {
                for (int j = 1 + lock.length - key.length; j < lock.length * 2; j++) {
                    int[][] temp = copy(map);

                    for (int x = i; x < i + key.length; x++) {
                        for (int y = j; y < j + key.length; y++)
                            temp[x][y] += key[x - i][y - j];
                    }

                    answer = isPromise(temp, lock.length);
                    if(answer) break;
                }
                if(answer) break;
            }

            if(answer) break;
            key = rotate(key);
        }

        return answer;
    }

    public static int[][] copy(int[][] map) {
        int[][] temp = new int[map.length][map.length];

        for (int i = 0; i < map.length; i++) {
            for(int j = 0; j < map.length; j++)
                temp[i][j] = map[i][j];
        }

        return temp;
    }

    public static boolean isPromise(int[][] map, int n) {
        for (int i = n; i < n * 2; i++) {
            for (int j = n; j < n * 2; j++) {
                if (map[i][j] == 0 || map[i][j] == 2)
                    return false;
            }
        }

        return true;
    }

    public static int[][] rotate(int[][] key) {
        int[][] temp = new int[key.length][key[0].length];

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++)
                temp[i][j] = key[key.length - 1 - j][i];
        }

        return temp;
    }
}
