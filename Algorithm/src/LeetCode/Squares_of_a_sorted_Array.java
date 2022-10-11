package LeetCode;

import java.util.Arrays;

public class Squares_of_a_sorted_Array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Arrays.stream(sortedSquares(new int[]{-4, -1, 0, 3, 10})).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(sortedSquares(new int[]{-7, -3, 2, 3, 11})).toArray()));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] output = new int[nums.length];
        int left = 0, right = nums.length - 1, idx = nums.length - 1;

        while (left <= right) {
            int leftValue = (int) Math.pow(nums[left], 2);
            int rightValue = (int) Math.pow(nums[right], 2);

            if (leftValue < rightValue) {
                output[idx--] = rightValue;
                right--;
            } else {
                output[idx--] = leftValue;
                left++;
            }
        }

        return output;
    }
}
