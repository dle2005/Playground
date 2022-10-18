package LeetCode;

import java.util.Stack;

public class Valid_Parentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : s.toCharArray()) {
            if (isOpenBracket(bracket)) {
                stack.add(bracket);
            } else {
                if (stack.isEmpty() || !isCorrectOrder(bracket, stack.peek())) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isCorrectOrder(char closeBracket, char openBracket) {
        return (openBracket == '(' && closeBracket == ')')
                || (openBracket == '[' && closeBracket == ']')
                || (openBracket == '{' && closeBracket == '}');
    }

    public static boolean isOpenBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }
}
