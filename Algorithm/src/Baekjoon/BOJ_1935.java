package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] operand = new int[N];
        for(int i = 0; i < N; i++)
            operand[i] = Integer.parseInt(br.readLine());

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isAlphabetic(c)) {
                stack.add((double) operand[c - 'A']);
            } else {
                double a = stack.pop();
                double b = stack.pop();

                if(c == '*') stack.push(b * a);
                else if(c == '/') stack.push(b / a);
                else if(c == '+') stack.push(b + a);
                else if(c == '-') stack.push(b - a);
            }
        }

        System.out.println(String.format("%.2f", stack.pop()));
    }
}
