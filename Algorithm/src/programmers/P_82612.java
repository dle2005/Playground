package programmers;

public class P_82612 {
    class Solution {
        public long solution(int price, int money, int count) {
            long payment = 0;

            for (int i = 1; i <= count; i++) {
                payment += price * i;
            }

            if (payment - money > 0) return payment - money;
            else return 0;
        }
    }
}
