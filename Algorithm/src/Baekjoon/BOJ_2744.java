package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if('a' <= c && c <= 'z') sb.append((char)(c - 'a' + 'A'));
            else sb.append((char)(c - 'A' + 'a'));
        }

        System.out.println(sb);
    }
}
