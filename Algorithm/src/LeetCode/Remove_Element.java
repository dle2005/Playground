package LeetCode;

public class Remove_Element {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int counterVal = 0;

        for (int i = 0; i < nums.length; i++) {
            nums[i - counterVal] = nums[i];

            if (nums[i] == val) {
                counterVal++;
            }
        }

        return nums.length - counterVal;
    }
}

