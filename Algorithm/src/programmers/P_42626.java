package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

public class P_42626 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        Queue<Integer> q = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++)
            q.offer(scoville[i]);

        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            if(q.peek() > K) {
                answer = i;
                break;
            }

            if(q.size() == 1) {
                answer = -1;
                break;
            }

            int first = q.poll();
            int second = q.poll();

            int sum = first + second * 2;
            q.offer(sum);
        }


        return answer;
    }
}
