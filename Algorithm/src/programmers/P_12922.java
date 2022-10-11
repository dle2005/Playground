package programmers;

public class P_12922 {
    class Solution {
        public String solution(int n) {
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < n; i++) {
                answer.append(i % 2 == 0 ? "수" : "박");
            }

            return answer.toString();
        }
    }
}
