package programmers;

import java.util.HashSet;
import java.util.Set;

public class P_86051 {
    class Solution {
        public int solution(int[] numbers) {
            int answer = 0;

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < 10; i++) set.add(i);

            for (int i = 0; i < numbers.length; i++) set.remove(numbers[i]);

            for (int n : set) answer += n;

            return answer;
        }
    }
}
