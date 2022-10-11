package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[] alp = new int[26];

        for (int i = 0; i < s.length(); i++)
            alp[s.charAt(i) - 'A']++;

        StringBuilder sb = new StringBuilder();

        String mid = "";
        boolean flag = true;

        for(int i = 0; i < 26; i++) {
            int n = alp[i];

            for(int j = 0; j < n/2; j++)
                sb.append((char)(i + 'A'));

            if(n % 2 != 0) {
                if(flag) {
                    mid = String.valueOf((char)(i + 'A'));
                    flag = false;
                }
                else {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
        }

        StringBuilder result = new StringBuilder(sb);
        result.append(String.valueOf(mid)).append(sb.reverse());
        System.out.println(result);
    }
}
