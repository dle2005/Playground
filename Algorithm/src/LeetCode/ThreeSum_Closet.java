package LeetCode;

import java.util.Arrays;

public class ThreeSum_Closet {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int answer = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                answer = getMinDiff(answer, sum, target);

                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return answer;
    }

    public static int getMinDiff(int sum1, int sum2, int target) {
        return getDiffWithTarget(sum1, target) > getDiffWithTarget(sum2, target) ? sum2 : sum1;
    }

    public static int getDiffWithTarget(int sum, int target) {
        return Math.abs(sum - target);
    }
}
