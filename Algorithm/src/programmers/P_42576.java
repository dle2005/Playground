package programmers;

import java.util.HashMap;
import java.util.Map;

public class P_42576 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < completion.length; i++) {
            if(map.containsKey(completion[i]))
                map.put(completion[i], map.get(completion[i]) + 1);
            else map.put(completion[i], 1);
        }

        for(int i = 0; i < participant.length; i++) {
            if(map.containsKey(participant[i])) {
                if(map.get(participant[i]) == 0) {
                    answer = participant[i];
                    break;
                }
                else map.put(participant[i], map.get(participant[i]) - 1);
            }
            else {
                answer = participant[i];
                break;
            }
        }

        return answer;
    }
}
