package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine(); // 기존 문자열
        String bom = br.readLine(); // 폭발 문자열

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i)); // 기존 문자열에서 하나씩 Stack 에 넣어줌

            // Stack 의 사이즈가 폭발 문자열 길이보다 크거나 같다면,
            // 폭발 문자열이 포함 되어 있을 수 있음, 검사 시 에러 방지도 가능
            boolean flag = true;

            if(stack.size() >= bom.length()) {
                for(int j = 0; j < bom.length(); j++) {
                    char s_char = stack.get(stack.size() - bom.length() + j);
                    char bom_char = bom.charAt(j);

                    if(s_char != bom_char) { // 폭파물과 일치하지 않는경우 
                        flag = false;
                        break;
                    }
                }

                if(flag) { // 폭파물과 일치하면 제거 
                    for(int j = 0; j < bom.length(); j++)
                        stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(char c : stack)
            sb.append(c);

        if(sb.length() == 0) System.out.println("FRULA");
        else System.out.println(sb.toString());

    }
}
