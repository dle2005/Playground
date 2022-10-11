package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1662 {
    public static class value {
        char num;
        int length;

        public value(char num, int length) {
            this.num = num;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Stack<value> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            // 닫힘괄호 만나기 전까지 계속 stack에 푸시
            if(s.charAt(i) != ')')
                stack.push(new value(s.charAt(i), 1));

            // 닫힘괄호를 만나면 열린괄호까지 pop을 진행
            if(s.charAt(i) == ')') {
                int length = 0;

                while(stack.peek().num != '(') {
                    length += stack.peek().length;
                    stack.pop();
                }
                stack.pop();

                // stack peek 만큼 반복해서 문자열을 저장
                length *= stack.peek().num - '0';
                stack.pop();

                stack.push(new value('1', length));
            }
        }

        int result = 0;
        for(value t : stack) {
            result += t.length;
        }
        System.out.println(result);
    }
}
