package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // N자리 숫자
        int K = Integer.parseInt(st.nextToken()); // 지울 숫자 K

        String s = br.readLine(); // 입력 수

        Stack<Integer> stack = new Stack<>();

        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';

            while (cnt < K && !stack.isEmpty() && stack.peek() < n) {
                stack.pop();
                cnt++;
            }

            stack.push(n);
        }

        for(int i = 0; i < N - K; i++) {
            sb.append(stack.get(i));
        }

        System.out.println(sb);

    }
}
