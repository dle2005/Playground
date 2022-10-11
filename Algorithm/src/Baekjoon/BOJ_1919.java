package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int[] a_alp = new int[26];
        int[] b_alp = new int[26];

        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            if(i < a.length()) a_alp[a.charAt(i) - 'a']++;
            if(i < b.length()) b_alp[b.charAt(i) - 'a']++;
        }

        int answer = 0;

        for (int i = 0; i < 26; i++)
            answer += Math.abs(a_alp[i] - b_alp[i]);

        System.out.println(answer);
    }
}
