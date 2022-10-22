package LeetCode;

public class Search_int_Rotated_Sorted_Array {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(search(new int[]{1}, 0));
    }

    public static int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target <= nums[hi] && nums[mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return nums[lo] == target ? lo : -1;
    }
}
