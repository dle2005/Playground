package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_92334 {
    public static void main(String[] args) {
        solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
    }
    public static int[] solution(String[] id_list, String[] reports, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> id_inx = new HashMap<>();
        Set<String>[] declaration_sets = new Set[id_list.length];
        int[] declaration_cnt = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            id_inx.put(id_list[i], i);

            declaration_sets[i] = new HashSet<>();
        }

        for (String report : reports) {
            String[] names = report.split(" ");

            if (!declaration_sets[id_inx.get(names[0])].contains(names[1])) {
                declaration_sets[id_inx.get(names[0])].add(names[1]);

                declaration_cnt[id_inx.get(names[1])]++;
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            int cnt = 0;

            for (String name : declaration_sets[i]) {
                if (declaration_cnt[id_inx.get(name)] >= k) {
                    cnt++;
                }
            }

            answer[i] = cnt;
        }

        return answer;
    }
}
