package LeetCode;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        threeSum(new int[]{0, 1, 1});
        threeSum(new int[]{0, 0, 0});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        if (nums[0] > 0) {
            return new ArrayList<>();
        }

        Set<List<Integer>> answer = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    answer.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return new ArrayList<>(answer);
    }
}
