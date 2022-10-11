package programmers;

import java.util.HashSet;
import java.util.Set;

public class P_77484 {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            Set<Integer> set = new HashSet<>(); // 1
            for (int n : win_nums) {
                set.add(n);
            }

            int win_cnt = 0; // 2
            int zero_cnt = 0;

            for (int n : lottos) {
                if (set.contains(n)) {
                    win_cnt++;
                }

                if (n == 0) {
                    zero_cnt++;
                }
            }

            return new int[]{Math.min(7 - (win_cnt + zero_cnt), 6), Math.min(7 - win_cnt, 6)}; // 3
        }
    }
}
