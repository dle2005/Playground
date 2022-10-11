package programmers;

import java.util.HashMap;
import java.util.Map;

public class P_42576_v2 {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            Map<String, Integer> map = new HashMap<>();

            for (String s : participant) { // 3
                map.put(s, map.getOrDefault(s, 0) + 1);
            }

            for (String s : completion) { // 4
                if (map.get(s) == 1) {
                    map.remove(s);
                } else {
                    map.put(s, map.get(s) - 1);
                }
            }

            String answer = ""; // 5

            for (String s : map.keySet()) {
                answer = s;
            }

            return answer;
        }
    }
}
