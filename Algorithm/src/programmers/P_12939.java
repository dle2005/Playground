package programmers;

import java.util.StringTokenizer;

public class P_12939 {
    public static void main(String[] args) {

    }
    public static String solution(String s) {
        String answer = "";

        StringTokenizer st = new StringTokenizer(s);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());

            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        answer = min + " " + max;
        return answer;
    }
}
