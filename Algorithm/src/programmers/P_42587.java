package programmers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class P_42587 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
    }
    public static class Paper {
        int p;
        int i;

        public Paper(int p, int i) {
            this.p = p;
            this.i = i;
        }
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());
        Queue<Paper> q = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            q.offer(new Paper(priorities[i], i));
            pq.offer(priorities[i]);
        }

        while(!q.isEmpty()) {
            Paper p = q.poll();

            if(p.p == pq.peek()) {
                answer++;

                if(p.i == location)
                    break;
                else pq.poll();
            }
            else {
                q.offer(p);
            }
        }

        return answer;
    }
}
