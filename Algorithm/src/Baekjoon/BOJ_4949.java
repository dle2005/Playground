package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_4949 {
    public static boolean VPS(String arg) {
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < arg.length(); i++) {
            if(arg.charAt(i) == '(' || arg.charAt(i) == '[')
                stack.push(arg.charAt(i));
            else if(arg.charAt(i) == ')') {
                if(stack.empty() || stack.peek() != '(' )
                    return false;
                else
                    stack.pop();
            }
            else if(arg.charAt(i) == ']') {
                if(stack.empty() || stack.peek() != '[' )
                    return false;
                else
                    stack.pop();
            }
        }

        if(stack.empty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String arg = sc.nextLine();

            if(arg.equals(".")) break;

            if(VPS(arg))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
