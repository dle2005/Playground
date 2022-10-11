package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int answer = 0;

        for(int i = 0; i <= a.length() - b.length(); i++) {
            String t = a.substring(i, i + b.length());

            if(t.equals(b)) {
                i += b.length() - 1;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
