package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_42577_v2 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (String phone_number : phone_book) {
            for (int idx = 0; idx < phone_number.length(); idx++) {
                if (set.contains(phone_number.substring(0, idx))) {
                    return false;
                }
            }
        }

        return answer;
    }
}
