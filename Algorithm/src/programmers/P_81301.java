package programmers;

public class P_81301 {
    public static void main(String[] args) {
        String t = "aaaaab";

        System.out.println(t.replace("ab", "b"));
        System.out.println(t.replaceAll("ab", "b"));
    }
    class Solution {

        public int solution(String s) {
            String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

            for (int i = 0; i < numbers.length; i++) {
                s.replace(numbers[i], String.valueOf(i));
            }

            return Integer.parseInt(s);
        }
    }
}
