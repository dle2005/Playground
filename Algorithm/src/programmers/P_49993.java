package programmers;

import java.util.HashSet;
import java.util.Set;

public class P_49993 {
    public static void main(String[] args) {

    }
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        char[] order = new char[skill.length()];
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < skill.length(); i++) {
            order[i] = skill.charAt(i);
            set.add(order[i]);
        }

        for (int i = 0; i < skill_trees.length; i++) {
            String s = skill_trees[i];
            int index = 0;
            boolean flag = true;

            for (int j = 0; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) continue;

                if (order[index++] != s.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) answer++;
        }

        return answer;
    }
}
