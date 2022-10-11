package LeetCode;

import java.util.Arrays;

public class Permutation_in_String {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Alp = new int[36];
        int[] s2Alp = new int[36];

        for (int i = 0; i < s1.length(); i++) {
            s1Alp[Character.getNumericValue(s1.charAt(i))]++;
            s2Alp[Character.getNumericValue(s2.charAt(i))]++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (Arrays.equals(s1Alp, s2Alp)) {
                return true;
            }

            s2Alp[Character.getNumericValue(s2.charAt(i - s1.length()))]--;
            s2Alp[Character.getNumericValue(s2.charAt(i))]++;
        }

        return Arrays.equals(s1Alp, s2Alp);
    }
}
