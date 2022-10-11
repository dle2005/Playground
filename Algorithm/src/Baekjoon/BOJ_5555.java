package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5555 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String p = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int[] pattern = getPattern(p);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder(br.readLine());
            sb.append(sb);

            answer += KMP(sb.toString(), p, pattern);
        }

        System.out.println(answer);
    }

    public static int KMP(String S, String P, int[] pattern) {
        for (int i = 0, j = 0; i < S.length(); i++) {
            while(j > 0 && S.charAt(i) != P.charAt(j))
                j = pattern[j - 1];

            if (S.charAt(i) == P.charAt(j)) {
                if(j == P.length()-1) return 1;
                else j++;
            }
        }

        return 0;
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
