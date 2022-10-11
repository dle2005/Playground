package LeetCode;

import java.util.Arrays;

public class Move_Zeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));

        nums = new int[]{0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
    }

    public static void moveZeroes(int[] nums) {
        int[] temp = nums.clone();
        int left = 0, right = nums.length - 1;

        for (int num : temp) {
            if (num == 0) {
                nums[right--] = num;
            } else {
                nums[left++] = num;
            }
        }
    }
}
