package LeetCode;

import java.util.Arrays;

public class Find_Numbers_with_Even_Number_of_Digits {
    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{12, 345, 2, 6, 7896}));
        System.out.println(findNumbers(new int[]{555, 901, 482, 1771}));
    }

    public static int findNumbers(int[] nums) {
        return (int) Arrays.stream(nums)
                .filter(num -> String.valueOf(num).length() % 2 == 0)
                .count();
    }
}
