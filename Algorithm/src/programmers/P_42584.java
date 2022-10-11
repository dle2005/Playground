package programmers;

import java.util.Stack;

public class P_42584 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,2,3}));
    }
    public static int[] solution(int[] prices) {
        int[] answer = {};

        int[] time = new int[prices.length];
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < prices.length-1; i++) {
            time[i] = 1;

            // 스택이 비어있지 않고, top price 가격이 지금들어 오는 가격 보다 크다면
            // 자신보다 큰 가격을 전부 stack 에서 제거
            while(!stack.isEmpty() && stack.peek()[0] > prices[i]) {
                int[] s = stack.pop();

                // 현재 인덱스에서 큐에 들어올때 인덱스만큼 빼면 몇초뒤에 빠진지 계산이 됨
                time[s[1]] = i - s[1];
            }

            stack.push(new int[]{prices[i], i});
        }

        while(!stack.isEmpty()) {
            int[] s = stack.pop();

            time[s[1]] = prices.length-1 - s[1];
        }

        return answer = time;
    }
}
