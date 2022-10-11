package programmers;

public class P_12954 {
    class Solution {
        public long[] solution(int x, int n) {
            long[] answer = new long[n];

            for (int i = 0; i < n; i ++) {
                answer[i] = (long)(i + 1) * x;
            }

            return answer;
        }
    }
}
