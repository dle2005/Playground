package LeetCode;

public class Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4,}));
    }

    public static int removeDuplicates(int[] nums) {
        int idx = 0;

        for (int num : nums) {
            if (idx == 0 || num > nums[idx - 1]) {
                nums[idx++] = num;
            }
        }

        return idx;
    }
}
