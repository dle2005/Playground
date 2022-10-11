package programmers;

import java.util.Arrays;

public class P_12941 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
        System.out.println(solution(new int[]{1, 2}, new int[]{3, 4}));
    }
    public static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0, j = B.length - 1; i < A.length && j >= 0; i++, j--) {
            answer += A[i] * B[j];
        }

        return answer;
    }
}
