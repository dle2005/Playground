package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<Integer>();

        int K = sc.nextInt();
        int sum = 0;

        for(int i = 0; i < K; i++) {
            int input = sc.nextInt();

            if(input == 0)
                stack.pop();
            else
                stack.push(input);
        }

        for(int n : stack) sum += n;

        System.out.println(sum);
    }
}
