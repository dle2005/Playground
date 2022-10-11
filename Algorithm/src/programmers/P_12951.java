package programmers;

public class P_12951 {
    class Solution {
        public String solution(String s) {
            StringBuilder sb = new StringBuilder();

            boolean blank = true;

            for (char c : s.toCharArray()) {
                sb.append(blank ? Character.toUpperCase(c) : Character.toLowerCase(c));
                blank = c == ' ' ? true : false;
            }

            return sb.toString();
        }
    }
}
