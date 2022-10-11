package LeetCode;

import java.util.Arrays;

public class Rotate_Array {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));

        nums = new int[]{-1, -100, 3, 99};
        rotate(nums, 2);
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;

        int[] output = nums.clone();

        for (int i = 0; i < nums.length; i++) {
            nums[k] = output[i];

            k = (k + 1) % nums.length;
        }
    }
}
