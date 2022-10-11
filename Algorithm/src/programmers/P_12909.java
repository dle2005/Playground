package programmers;

import java.util.Stack;

public class P_12909 {
    public static void main(String[] args) {

    }
    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') stack.add(c);
            else if (c == ')') {
                if (stack.isEmpty()) return false;
                else if (stack.peek() != '(') return false;
                else stack.pop();
            }
        }

        return stack.isEmpty() ? true : false;
    }
}
