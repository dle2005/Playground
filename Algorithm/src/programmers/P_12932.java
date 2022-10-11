package programmers;

import java.util.ArrayList;
import java.util.List;

public class P_12932 {

    class Solution {
        public int[] solution(long n) {
            List<Integer> list = new ArrayList<>();

            while(n != 0) {
                list.add((int)(n % 10));
                n /= 10;
            }

            int[] answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}
