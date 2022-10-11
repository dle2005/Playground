package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String a = s.split(" ")[0];
        String b = s.split(" ")[1];

        int answer = Integer.MAX_VALUE;

        for(int i = 0; i <= b.length() - a.length(); i++) {
            int cnt = 0;

            for(int j = 0; j < a.length(); j++) {
                if(a.charAt(j) != b.charAt(j + i)) cnt++;
            }

            answer = Math.min(answer, cnt);
        }

        System.out.println(answer);
    }
}
