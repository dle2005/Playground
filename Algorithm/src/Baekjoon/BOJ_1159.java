package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] alp = new int[26];

        for (int i = 0; i < N; i++)
            alp[br.readLine().charAt(0) - 'a']++;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if(alp[i] >= 5) sb.append((char) (i + 'a'));
        }

        if(sb.length() == 0) sb.append("PREDAJA");

        System.out.println(sb);
    }
}
