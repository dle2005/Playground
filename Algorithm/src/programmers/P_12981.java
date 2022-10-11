package programmers;

import java.util.HashSet;
import java.util.Set;

public class P_12981 {
    public static void main(String[] args) {
//        int[] answer = solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        int[] answer = solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"});

        for (int n : answer) System.out.println(n);
    }
    public static int[] solution(int n, String[] words) {
        int[] answer = {};

        int person = 1;
        int turn = 1;

        Set<String> set = new HashSet<>();
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {

            person = person % n + 1;
            if (i % n == 0) turn++;

            if (set.contains(words[i]) || words[i].charAt(0) != words[i-1].charAt(words[i-1].length() - 1))
                return answer = new int[]{person, turn};

            set.add(words[i]);
        }

        return answer = new int[]{0, 0};
    }
}
