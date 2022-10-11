package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class P_42583 {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7,4,5,6}));
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();
        int time = 1, cur_weight = 0, cur_truck = 0;

        while(true) {
            if(!queue.isEmpty() && bridge_length == time - queue.peek()[1]) {
                int[] truck = queue.poll();
                cur_weight -= truck[0];
            }

            if(cur_truck < truck_weights.length && cur_weight + truck_weights[cur_truck] <= weight) {
                queue.offer(new int[]{truck_weights[cur_truck], time});
                cur_weight += truck_weights[cur_truck];
                cur_truck++;
            }

            if(queue.isEmpty()) {
                answer = time;
                break;
            }

            time++;
        }

        return answer;
    }
}
