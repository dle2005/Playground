package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number {
    public static void main(String[] args) {
        letterCombinations("23");
        letterCombinations("");
        letterCombinations("2");
    }

    private static List<String> answer;
    private static char[] combination;
    private static final String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        answer = new ArrayList<>();
        combination = new char[digits.length()];

        getCombination(digits, 0, 0);

        return digits.length() == 0 ? new ArrayList<>() : answer;
    }

    public static void getCombination(String digits, int index, int start) {
        if (index == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (char c : combination) {
                sb.append(c);
            }

            answer.add(sb.toString());

            return;
        }


        for (int i = start; i < digits.length(); i++) {
            String letter = letters[digits.charAt(i) - '0'];
            for (int j = 0; j < letter.length(); j++) {
                combination[index] = letter.charAt(j);

                getCombination(digits, index + 1, i + 1);
            }
        }
    }
}
