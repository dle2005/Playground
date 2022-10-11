package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_12910 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 9, 7, 10}, 5));
    }
    public static int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++)
            if(arr[i] % divisor == 0) list.add(arr[i]);

        if(list.isEmpty()) list.add(-1);

        Collections.sort(list);

        return answer = list.stream().mapToInt(Integer::intValue).toArray();
    }
}
