package programmers;

import java.util.Stack;

public class P_12906_v2 {
    public class Solution {
        public int[] solution(int []arr) {
            Stack<Integer> stack = new Stack<>();

            for (int n : arr) {
                if (stack.isEmpty() || stack.peek() != n) {
                    stack.add(n);
                }
            }

            int[] answer = new int[stack.size()];
            int index = 0;
            for (int n : stack) {
                answer[index++] = n;
            }

            return answer;
        }
    }
}
