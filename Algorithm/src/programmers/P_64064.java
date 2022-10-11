package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_64064 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }

    public static int answer;
    public static String[] combination;
    public static boolean[] visit;

    public static List<Set<String>> list = new ArrayList<>();

    public static int solution(String[] user_id, String[] banned_id) {
        answer = 0;

        combination = new String[banned_id.length];
        visit = new boolean[user_id.length];

        permutation(0, user_id, banned_id);

        return answer;
    }

    public static void permutation(int depth, String[] user_id, String[] banned_id) {
        if (depth == banned_id.length) {
            Set<String> set = new HashSet<>();
            for(String s : combination) set.add(s);

            boolean flag = true;
            for(Set s : list) {
                if (s.containsAll(set)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                list.add(set);
                answer++;
            }

            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if(visit[i]) continue;

            String regex = banned_id[depth];
            regex = regex.replace('*', '.');

            if(!user_id[i].matches(regex)) continue;

            visit[i] = true;
            combination[depth] = user_id[i];
            permutation(depth + 1, user_id, banned_id);
            visit[i] = false;
        }
    }
}
