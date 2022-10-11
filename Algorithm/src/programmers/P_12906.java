package programmers;

import java.util.ArrayList;
import java.util.List;

public class P_12906 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 3, 3, 0, 1, 1}));
    }
    public static int[] solution(int []arr) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        int last_word = -1;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != last_word) {
                list.add(arr[i]);
                last_word = arr[i];
            }
        }

        return answer = list.stream().mapToInt(Integer::intValue).toArray();
    }
}
