package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_12933 {
    class Solution {
        public long solution(long n) {
            long answer = 0;

            List<Integer> list = new ArrayList<>();
            while (n != 0) {
                list.add((int)(n % 10));
                n /= 10;
            }

            Collections.sort(list, Collections.reverseOrder());

            for (int t : list) {
                answer = (answer * 10) + t;
            }

            return answer;
        }
    }
}
