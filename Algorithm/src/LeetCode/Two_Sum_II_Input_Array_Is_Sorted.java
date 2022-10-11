package LeetCode;

import java.util.Arrays;

public class Two_Sum_II_Input_Array_Is_Sorted {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                Arrays.stream(twoSum(new int[]{2, 7, 11, 15}, 9)).toArray()));

        System.out.println(Arrays.toString(
                Arrays.stream(twoSum(new int[]{2, 3, 4}, 6)).toArray()));

        System.out.println(Arrays.toString(
                Arrays.stream(twoSum(new int[]{-1, 0}, -1)).toArray()));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (numbers[l] + numbers[r] != target) {
            if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[]{++l, ++r};
    }
}
