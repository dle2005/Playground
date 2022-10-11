package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = 1;
        while (true) {
            String s = br.readLine();

            if (s.contains("-")) break;

            Stack<Character> stack = new Stack();
            int cnt = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '{') {
                    stack.push(c);
                }
                else if (c == '}') {
                    if (stack.isEmpty()) {
                        cnt++;
                        stack.push('{');
                    } else stack.pop();
                }
            }

            cnt += stack.size() / 2;

            sb.append(num++ + ". ").append(cnt ).append("\n");
        }

        System.out.println(sb);
    }
}
