package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    public static void main(String[] args) {
        twoSum(new int[]{2, 7, 11, 15}, 9);
        twoSum(new int[]{3, 2, 4}, 6);
        twoSum(new int[]{3, 3}, 6);
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public static int[] twoSum_v2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        return null;
    }
}
