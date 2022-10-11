package programmers;
import java.util.*;

public class P_68644 {
    class Solution {
        public int[] solution(int[] numbers) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    set.add(numbers[i] + numbers[j]);
                }
            }

            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);

            int[] answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }
}
