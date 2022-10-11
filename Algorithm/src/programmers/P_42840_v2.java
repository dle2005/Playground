package programmers;

import java.util.ArrayList;
import java.util.List;

public class P_42840_v2 {

    class Solution {
        public int[] solution(int[] answers) {
            int[][] patterns = { // 1
                    {1, 2, 3, 4, 5},
                    {2, 1, 2, 3, 2, 4, 2, 5},
                    {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
            };

            int[] scores = new int[3];

            for (int i = 0; i < 3; i++) { // 2
                for (int j = 0; j < answers.length; j++) {
                    if (patterns[i][j % patterns[i].length] == answers[j]) {
                        scores[i]++;
                    }
                }
            }

            int max = Math.max(scores[0], Math.max(scores[1], scores[2])); // 3

            List<Integer> list = new ArrayList<>(); // 4
            for (int i = 0; i < 3; i++) {
                if (scores[i] == max) {
                    list.add(i + 1);
                }
            }

            int[] answer = new int[list.size()]; // 5
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }
}
