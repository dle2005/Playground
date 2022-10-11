package programmers;

import java.util.Arrays;

public class P_42862 {
    public static void main(String[] args) {
        solution(5, new int[]{2, 3, 4}, new int[]{1, 2, 3});
    }
    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int answer = n - lost.length;

        for (int i = 0, j = 0; i < lost.length && j < reserve.length;) {
            if (i < lost.length - 1 && lost[i + 1] == reserve[j]) {
                answer++;
                lost[i + 1] = -1;
                j++;
            }
            else if (Math.abs(lost[i] - reserve[j]) <= 1) {
                answer++;
                i++;
                j++;
            } else if (lost[i] > reserve[j]) {
                j++;
            } else {
                i++;
            }

            System.out.println(i + " " + j);
        }

        System.out.println(answer);
        return answer;
    }
}
