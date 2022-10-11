package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isAlphabetic(c)) {
                sb.append(c);
                continue;
            }
            else {
                if (c == '(')
                    stack.push(c);
                else if (c == ')') {
                    while (stack.peek() != '(')
                        sb.append(stack.pop());
                    stack.pop();
                }
                else if (c == '+' || c == '-') {
                    while (!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/'))
                        sb.append(stack.pop());
                    stack.push(c);
                }
                else if (c == '*' || c == '/') {
                    while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/'))
                        sb.append(stack.pop());
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty())
            sb.append(stack.pop());

        System.out.println(sb);
    }
}
