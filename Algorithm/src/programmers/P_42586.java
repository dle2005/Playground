package programmers;

import java.util.ArrayList;
import java.util.List;

public class P_42586 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        int index = 0;

        while(index != progresses.length) {
            int cnt = 0;

            for(int i = index; i < progresses.length; i++) {
                if(progresses[i] < 100) break;
                else cnt++;
            }

            index += cnt;
            if(cnt != 0) list.add(cnt);

            for(int i = index; i < progresses.length; i++)
                progresses[i] += speeds[i];
        }

        return answer = list.stream().mapToInt(Integer::intValue).toArray();
    }
}
