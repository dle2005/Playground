package programmers;

public class P_86491 {
    class Solution {
        public int solution(int[][] sizes) {
            int width = 0, height = 0;

            for (int[] size : sizes) {
                width = Math.max(width, Math.max(size[0], size[1]));
                height = Math.max(height, Math.min(size[0], size[1]));
            }

            return width * height;
        }
    }
}
