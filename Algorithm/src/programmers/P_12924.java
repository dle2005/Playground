package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class P_12924 {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }
    public static int solution(int n) {
        int answer = 1;

        int sum = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i < n / 2 + 2; i++) {
            if(sum <= n) {
                q.offer(i);
                sum += i;
            }
            if(sum > n) {
                while(sum > n) sum -= q.poll();
            }

            if(sum == n) {
                answer++;
                sum -= q.poll();
            }
        }

        return answer;
    }
}
