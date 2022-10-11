package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_17684 {
    public static void main(String[] args) {
        System.out.println(solution("KAKAO"));
        System.out.println(solution("TOBEORNOTTOBEORTOBEORNOT"));
        System.out.println(solution("ABABABABABABABAB"));
    }
    public static int[] solution(String msg) {
        int[] answer = {};

        Map<String, Integer> map = new HashMap<>();
        for(int i = 1; i <= 26; i++)
            map.put(String.valueOf((char)(64 + i)), i);

        List<Integer> list = new ArrayList<>();

        int index = 27;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            sb.append(msg.charAt(i));
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), index++);

                list.add(map.get(sb.substring(0, sb.length()-1)));

                sb = new StringBuilder();
                i--;
            }
        }
        list.add(map.get(sb.toString()));

        return answer = list.stream().mapToInt(Integer::intValue).toArray();
    }
}
