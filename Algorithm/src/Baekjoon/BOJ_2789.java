package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_2789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        char[] filter = "CAMBRIDGE".toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c : filter) set.add(c);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(!set.contains(c)) sb.append(c);
        }

        System.out.println(sb);
    }
}
