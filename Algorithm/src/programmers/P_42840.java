package programmers;

import java.util.ArrayList;
import java.util.List;

public class P_42840 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,5}));
    }
    public static int[] solution(int[] answers) {
        int[] answer = {};

        int[][] supoja = new int[3][];
        supoja[0] = new int[]{1, 2, 3, 4, 5};
        supoja[1] = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        supoja[2] = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] correct = new int[3];
        int zero_index = 0, one_index = 0, two_index = 0;

        for(int i = 0; i < answers.length; i++) {
            if(supoja[0][zero_index] == answers[i]) correct[0]++;
            if(supoja[1][one_index] == answers[i]) correct[1]++;
            if(supoja[2][two_index] == answers[i]) correct[2]++;

            zero_index = (zero_index + 1) % supoja[0].length;
            one_index = (one_index + 1) % supoja[1].length;
            two_index = (two_index + 1) % supoja[2].length;
        }

        int max = 0;
        for(int i = 0; i < 3; i++)
            max = Math.max(max, correct[i]);

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(max == correct[i]) list.add(i + 1);
        }

        return answer = list.stream().mapToInt(Integer::intValue).toArray();
    }
}
