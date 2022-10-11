package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_42748 {
    public static void main(String[] args) {

    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();


        for(int i = 0; i < commands.length; i++) {
            int left = commands[i][0];
            int right = commands[i][1];
            int find = commands[i][2];

            List<Integer> temp = new ArrayList<>();
            for(int j = left - 1; j < right; j++)
                temp.add(array[j]);

            Collections.sort(temp);

            list.add(temp.get(find-1));
        }

        return answer = list.stream().mapToInt(Integer::intValue).toArray();
    }
}
