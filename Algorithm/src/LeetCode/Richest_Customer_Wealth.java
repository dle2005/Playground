package LeetCode;

import java.util.Arrays;

public class Richest_Customer_Wealth {
    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
        System.out.println(maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}));
    }

    public static int maximumWealth(int[][] accounts) {
        int output = 0;

        for (int[] account : accounts) {
            output = Math.max(output, Arrays.stream(account).sum());
        }

        return output;
    }
}
