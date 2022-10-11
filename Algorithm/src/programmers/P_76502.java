package programmers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class P_76502 {
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
        System.out.println(solution("}}}"));
    }
    public static int solution(String s) {
        int answer = 0;

        Deque<Character> queue = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++)
            queue.offer(s.charAt(i));

        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (char c : queue) {
                if (c == '[' || c == '{' || c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }

                    if (c == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else if (c == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (c == ')' && stack.peek() == '(') {
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty()) flag = false;

            if(flag) answer++;

            queue.offerLast(queue.pollFirst());
        }

        return answer;
    }
}
