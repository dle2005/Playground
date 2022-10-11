package programmers;

import java.util.*;

public class P_72411 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4}));
    }
    public static Map<String, Integer> map = new HashMap<>();
    public static char[] temp;
    public static int[] cnt;

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        cnt = new int[11];

        for(int i = 0; i < orders.length; i++) {
            for(int j = 0; j < course.length; j++) {
                if(course[j] <= orders[i].length()) {
                    temp = new char[course[j]];
                    dfs(orders[i], 0, course[j], 0);
                }
            }
        }

        List<String> list = new ArrayList<>();

        for(Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
            if(cnt[m.getKey().length()] == m.getValue()) list.add(m.getKey());
        }

        Collections.sort(list);

        return answer = list.toArray(list.toArray(new String[0]));
    }

    public static void dfs(String s, int depth, int max, int start) {
        if(depth == max) {
            char[] te = Arrays.copyOf(temp, temp.length);
            Arrays.sort(te);
            String t = new String(te);
            if(map.containsKey(t))
                map.put(t, map.get(t) + 1);
            else map.put(t, 1);

            cnt[max] = Math.max(cnt[max], map.get(t));
            return;
        }

        for(int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            temp[depth] = c;
            dfs(s, depth + 1, max, i + 1);
        }
    }
}
