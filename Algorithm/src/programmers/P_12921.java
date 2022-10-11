package programmers;

public class P_12921 {
    class Solution {
        public boolean[] isPrime;

        public int solution(int n) {
            isPrime = new boolean[n + 1];
            eratosthenes(n);

            int answer = 0;
            for (int i = 2; i <= n; i++) {
                if (!isPrime[i]) {
                    answer++;
                }
            }
            return answer;
        }

        public void eratosthenes(int n) {
            isPrime[0] = isPrime[1] = true;

            for (int i = 2; i * i <= n; i++) {
                if (!isPrime[i]) {
                    for (int j = i * i; j <= n; j += i) {
                        isPrime[j] = true;
                    }
                }
            }
        }
    }
}
