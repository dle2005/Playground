package programmers;

public class P_12935 {
    class Solution {
        public int[] solution(int[] arr) {
            if (arr.length == 1) { // 1
                return new int[]{-1};
            } else {
                int min = Integer.MAX_VALUE; // 2
                for (int n : arr) {
                    min = Math.min(n, min);
                }

                int[] answer = new int[arr.length - 1]; // 3

                int index = 0; // 4
                for (int n : arr) {
                    if (n != min) {
                        answer[index++] = n;
                    }
                }

                return answer;
            }
        }
    }
}
