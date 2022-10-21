package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(1));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();

        backtracking(output, new char[n * 2], 0, 0, n);

        return output;
    }

    public static void backtracking(List<String> output, char[] arr, int open, int close, int n) {
        if (open + close == n * 2) {
            output.add(String.valueOf(arr));
            return;
        }

        int idx = open + close;

        if (open < n) {
            arr[idx] = '(';
            backtracking(output, arr, open + 1, close, n);
        }

        if (close < open) {
            arr[idx] = ')';
            backtracking(output, arr, open, close + 1, n);
        }
    }
}
