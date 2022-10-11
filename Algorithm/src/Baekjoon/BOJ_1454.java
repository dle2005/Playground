package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1454 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringBuilder sb = new StringBuilder(s.substring(0, 1));

        for (int i = 1; i < s.length(); i++) {
            if(sb.charAt(i - 1) < s.charAt(i))
                sb.insert(0, String.valueOf(s.charAt(i)));
            else sb.append(s.charAt(i));
        }

        System.out.println(sb.reverse());
    }
}
