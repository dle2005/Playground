package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_9012 {
    public static boolean VPS(String arg) {
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < arg.length(); i++) {
            if(arg.charAt(i) == '(')
                stack.push(arg.charAt(i));
            else if(stack.empty())
                return false;
            else
                stack.pop();
        }

        if(stack.empty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            String arg = sc.next();

            if(VPS(arg))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
