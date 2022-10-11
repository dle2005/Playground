package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2800 {
    public static class Bracket {
        int left;
        int right;

        public Bracket(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static int num;
    public static List<Bracket> list;
    public static char[] arr;
    public static HashSet<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>(); // 열린 괄호 인덱스 저장용도
        list = new ArrayList<>();

        String s = br.readLine(); // 문자열로 입력 받고
        arr = new char[s.length()]; // char 배열로 변경
        for(int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);

            if(arr[i] == '(') stack.push(i); // 열린 괄호시 스택에 추가
            else if(arr[i] == ')') // 닫힌 괄호인 경우
                // 스택에서 열린괄호의 인덱스를 pop 해서 가져오고
                // 열린, 닫힌 괄호의 인덱스를 pair로 list에 저장
                list.add(new Bracket(stack.pop(), i));
        }

        num = list.size();

        answer = new HashSet<>();

        recursive(0, arr);

        List<String> ans = new ArrayList<>(answer);
        Collections.sort(ans);

        for(int i = 1; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static void recursive(int n, char[] newArr) {
        if(n >= num) {
            String s = new String(newArr);
            s = s.replaceAll(" ", ""); // 공벡을 제거
            answer.add(s); // 정답 목록에 추가
        }
        else {
            Bracket bracket = list.get(n); // n번째 괄호 쌍

            arr[bracket.left] = ' '; // 공백으로 변경
            arr[bracket.right] = ' ';
            recursive(n+1, arr);

            arr[bracket.left] = '('; // 현제 괄호 쌍 생략
            arr[bracket.right] = ')';
            recursive(n+1, arr);
        }
    }
}
