package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int a1 = 0, a2 = 0;
        int b1 = 0, b2 = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(-2);
                a1++;
            }

            if (c == '[') {
                stack.push(-3);
                b1++;
            }

            if (c == ')') {
                a2++;

                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }

                int sum = 0;
                while (!stack.isEmpty()) {
                    if (stack.peek() == -2) {
                        stack.pop();
                        break;
                    } else if (stack.peek() == -3) {
                        System.out.println(0);
                        return;
                    } else sum += stack.pop();
                }
                if (sum == 0) sum = 1;
                sum *= 2;
                stack.push(sum);
            }

            if (c == ']') {
                b2++;

                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }

                int sum = 0;
                while (!stack.isEmpty()) {
                    if (stack.peek() == -3) {
                        stack.pop();
                        break;
                    } else if (stack.peek() == -3) {
                        System.out.println(0);
                        return;
                    }
                    else sum += stack.pop();
                }
                if (sum == 0) sum = 1;
                sum *= 3;
                stack.push(sum);
            }
        }

        if (a1 != a2 || b1 != b2) {
            System.out.println(0);
            return;
        }

        int answer = 0;
        for (int t : stack) {
            if (t < 0) {
                System.out.println(0);
                return;
            }
            else answer += t;
        }
        System.out.println(answer);
    }
}
