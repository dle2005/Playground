package programmers;

import java.util.Arrays;

public class P_12915 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"sun", "bed", "car"}, 1));
    }
    public static String[] solution(String[] strings, int n) {
        String[] answer = {};

        Arrays.sort(strings);

        Arrays.sort(strings, (o1, o2) -> o1.charAt(n) - o2.charAt(n));

        return answer = strings;
    }
}
