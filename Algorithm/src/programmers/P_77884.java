package programmers;

public class P_77884 {
    class Solution {
        public int solution(int left, int right) {
            int answer = 0;

            for (int i = left; i <= right; i++) {
                int cnt = measure(i);

                if (cnt % 2 == 0) answer += i;
                else answer -= i;
            }

            return answer;
        }

        public int measure(int n) {
            int cnt = 0;

            for (int i = 1; i < Math.sqrt(n); i++) {
                if (n % i ==0) cnt += 2;
            }

            if (n % Math.sqrt(n) == 0) cnt++;

            return cnt;
        }
    }
}
