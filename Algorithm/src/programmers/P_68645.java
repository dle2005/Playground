package programmers;

import java.util.ArrayList;
import java.util.List;

public class P_68645 {
    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(5));
        System.out.println(solution(6));
    }
    public static int[] solution(int n) {
        int[] answer = {};

        int[][] map = new int[n][n];
        int i = -1, j = 0, dir = 0, num = 1;

        while (n-- > 0) {
            if (dir == 0) {
                for (int k = 0; k <= n; k++) {
                    i++;
                    map[i][j] = num++;
                }
                dir = (dir + 1) % 3;
            }
            else if (dir == 1) {
                for (int k = 0; k <= n; k++) {
                    j++;
                    map[i][j] = num++;
                }
                dir = (dir + 1) % 3;
            }
            else if (dir == 2) {
                for (int k = 0; k <= n; k++) {
                    i--; j--;
                    map[i][j] = num++;
                }
                dir = (dir + 1) % 3;
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int[] x : map) {
            for (int y : x) {
                if(y != 0) list.add(y);
            }
        }

        return answer = list.stream().mapToInt(Integer::intValue).toArray();
    }
}
