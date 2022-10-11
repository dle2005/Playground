package programmers;

import java.util.Arrays;

public class P_42784_v2 {
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            int index = 0;

            for (int[] command : commands) {
                int i = command[0];
                int j = command[1];
                int k = command[2];

                int[] temp = Arrays.copyOfRange(array, i - 1, j);

                Arrays.sort(temp);

                answer[index++] = temp[k - 1];
            }

            return answer;
        }
    }
}
