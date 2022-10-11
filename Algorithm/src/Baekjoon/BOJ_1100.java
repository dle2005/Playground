package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        for(int i = 0; i < 8; i++) {
            String s = br.readLine();

            for(int j = 0; j < 8; j++) {
                if(i % 2 == 0) {
                    if(j % 2 == 0) {
                        if(s.charAt(j) == 'F') answer++;
                    }
                }
                else {
                    if(j % 2 == 1) {
                        if(s.charAt(j) == 'F') answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
