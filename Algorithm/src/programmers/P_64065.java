package programmers;

import java.util.*;

public class P_64065 {
    public static void main(String[] args) {
        System.out.println(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
        System.out.println(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
        System.out.println(solution("{{20,111},{111}}"));
        System.out.println(solution("{{123}}"));
        System.out.println(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"));
    }
    public static int[] solution(String s) {
        int[] answer = {};

        s = s.replaceAll("[{},]", " ");
        s = s.replaceAll("\\s+", " ");
        s = s.trim();

        String[] arr = s.split(" ");

        Map<Integer, Integer> map = new HashMap<>();

        for (String t : arr) {
            int n = Integer.parseInt(t);

            if (map.containsKey(n))
                map.put(n, map.get(n) + 1);
            else map.put(n, 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        List<Integer> answer_list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> m : list)
            answer_list.add(m.getKey());


        return answer = answer_list.stream().mapToInt(Integer::intValue).toArray();
    }
}
