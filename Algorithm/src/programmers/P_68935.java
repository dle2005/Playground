package programmers;

import java.util.ArrayList;
import java.util.List;

public class P_68935 {
    public static void main(String[] args) {
        System.out.println(solution(45));
    }
    public static int solution(int n) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();

        while(n != 0) {
            list.add(n % 3);
            n /= 3;
        }

        int size = list.size() - 1;
        for(int i = 0; i < list.size(); i++) {
            answer += list.get(i) * Math.pow(3, size);
            size--;
        }

        return answer;
    }
}
