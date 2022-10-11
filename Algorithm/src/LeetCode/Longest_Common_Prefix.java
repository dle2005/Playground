package LeetCode;

public class Longest_Common_Prefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
    public static String longestCommonPrefix(String[] strs) {
        String answer = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(answer) != 0) {
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        return answer;
    }
}
