package programmers;

public class P_12930 {
    class Solution {
        public String solution(String s) {
            StringBuilder sb = new StringBuilder();

            int index = 0;
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    index = 0;
                    sb.append(" ");
                } else if (index++ % 2 == 0) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }

            return sb.toString();
        }
    }
}
