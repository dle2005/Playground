package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder pattern = new StringBuilder("IOI");
        for(int i = 1; i < N; i++) pattern.append("OI");

        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] pat = getPattern(pattern.toString());

        int answer = KMP(s, pattern.toString(), pat);

        System.out.println(answer);
    }

    public static int KMP(String s, String k, int[] pattern) {
        int cnt = 0;

        for (int i = 0, j = 0; i < s.length(); i++) {
            while(j > 0 && s.charAt(i) != k.charAt(j))
                j = pattern[j - 1];

            if (s.charAt(i) == k.charAt(j)) {
                if (j == k.length() - 1) {
                    j = pattern[j];
                    cnt++;
                }
                else j++;
            }
        }

        return cnt;
    }

    public static int[] getPattern(String p) {
        int[] pattern = new int[p.length()];

        for (int i = 1, j = 0; i < p.length(); i++) {
            while(j > 0 && p.charAt(i) != p.charAt(j))
                j = pattern[j - 1];

            if(p.charAt(i) == p.charAt(j))
                pattern[i] = ++j;
        }

        return pattern;
    }
}
