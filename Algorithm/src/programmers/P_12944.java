package programmers;

public class P_12944 {
    class Solution {
        public double solution(int[] arr) {
            double answer = 0;

            for (int n : arr) {
                answer += n;
            }

            return answer / arr.length;
        }
    }
}
