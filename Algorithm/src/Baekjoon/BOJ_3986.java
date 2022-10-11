package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        while (n-- > 0) {
            String s = br.readLine();

            Stack<Character> stack = new Stack<>();

            if (s.length() % 2 != 0) continue;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (!stack.isEmpty() && stack.peek() == c) stack.pop();
                else stack.push(c);
            }

            if (stack.isEmpty()) answer++;
        }

        System.out.println(answer);
    }
}
