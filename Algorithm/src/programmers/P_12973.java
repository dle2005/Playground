package programmers;

import java.util.Stack;

public class P_12973 {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }
    public static int solution(String s)
    {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(stack.isEmpty() || c != stack.peek()) stack.push(c);
            else if(c == stack.peek()) stack.pop();
        }

        if(stack.isEmpty()) answer = 1;
        else answer = 0;

        return answer;
    }
}
