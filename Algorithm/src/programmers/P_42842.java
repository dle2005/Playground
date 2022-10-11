package programmers;

import java.util.ArrayList;
import java.util.List;

public class P_42842 {
    public static void main(String[] args) {

    }
    public static int[] solution(int brown, int yellow) {
        int[] answer = {};

        List<int[]> list = getPair(brown + yellow);

        for (int[] pair : list) {
            int row = pair[0];
            int column = pair[1];

            int border_size = row * 2 + (column - 2) * 2;
            int center_size = row * column - border_size;

            if (border_size >= brown && center_size >= yellow) {
                return new int[]{row, column};
            }
        }

        return answer;
    }

    public static List<int[]> getPair(int total) {
        List<int[]> list = new ArrayList<>();

        for (int i = 3; i <= Math.sqrt(total); i++) {
            if (total % i == 0) {
                list.add(new int[]{total / i, i});
            }
        }

        return list;
    }
}
