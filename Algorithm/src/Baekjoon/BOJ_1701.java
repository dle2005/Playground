package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1701 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int answer = 0;

        for (int i = 0; i < s.length(); i++)
            answer = Math.max(answer, getPattern(s.substring(i, s.length())));

        System.out.println(answer);
    }

    public static int getPattern(String s) {
        int[] pattern = new int[s.length()];
        int max = 0;

        for (int i = 1, j = 0; i < s.length(); i++) {
            while(j > 0 && s.charAt(i) != s.charAt(j))
                j = pattern[j - 1];

            if (s.charAt(i) == s.charAt(j)) {
                pattern[i] = ++j;
                max = Math.max(max, pattern[i]);
            }
        }

        return max;
    }
}
