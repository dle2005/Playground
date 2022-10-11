package programmers;

public class P_87390 {
    class Solution {
        public int[] solution(int n, long left, long right) {
            int[] answer = new int[(int)(right - left) + 1];

            for (int i = 0; i < answer.length; i++) {
                int max = Math.max((int)((left + i) / n), (int)((left + i) % n));
                answer[i] = max + 1;
            }

            return answer;
        }
    }
}
