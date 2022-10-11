package programmers;

import java.util.HashSet;
import java.util.Set;

public class P_1845 {
    public static void main(String[] args) {

    }
    public static int solution(int[] nums) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);

        return set.size() >= nums.length / 2 ? nums.length / 2 : set.size();
    }
}
