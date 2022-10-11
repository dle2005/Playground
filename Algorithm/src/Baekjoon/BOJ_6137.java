package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6137 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(br.readLine());
        String s = sb.toString();

        StringBuilder result = new StringBuilder();
        int front = 0, back = N - 1;

        while (front <= back) {
            if (s.charAt(front) > s.charAt(back)) {
                result.append(s.charAt(back--));
            } else if (s.charAt(front) < s.charAt(back)) {
                result.append(s.charAt(front++));
            } else {
                int fn = front + 1, bn = back - 1, l = result.length();

                while (fn <= bn) {
                    if (s.charAt(fn) > s.charAt(bn)) {
                        result.append(s.charAt(back--));
                        break;
                    } else if (s.charAt(fn) < s.charAt(bn)) {
                        result.append(s.charAt(front++));
                        break;
                    }

                    fn++;
                    bn--;
                }

                if (l == result.length()) result.append(s.charAt(front++));
            }
        }

        for (int i = 80; i < result.length(); i += 80) {
            result.insert(i++, "\n");
        }

        System.out.println(result);
    }
}
