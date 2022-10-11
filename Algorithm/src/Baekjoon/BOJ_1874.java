package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<Integer>();

        int n = sc.nextInt();
        int topValue = 0;

        for(int i = 0; i < n; i++) {
            int input = sc.nextInt();

            if(input > topValue) {
                for(int j = topValue + 1; j <= input; j++) {
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                topValue = input;
            }
            else if(stack.peek() != input) {
                System.out.println("NO");
                System.exit(0);
            }

            stack.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);
    }
}
