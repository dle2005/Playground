package programmers;

public class P_12926 {
    class Solution {
        public String solution(String s, int n) {
            StringBuilder answer = new StringBuilder(); // 1

            for (char c : s.toCharArray()) {
                if (Character.isLowerCase(c)) { // 2
                    answer.append((char)((c + n - 'a') % 26 + 'a'));
                } else if (Character.isUpperCase(c)) { // 2
                    answer.append((char)((c + n - 'A') % 26 + 'A'));
                } else { // 3
                    answer.append(c);
                }
            }

            return answer.toString();
        }
    }
}
