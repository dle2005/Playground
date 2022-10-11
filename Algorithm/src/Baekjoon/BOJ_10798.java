package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] inputs = new String[15];
        for(int i = 0; i < 15; i++) inputs[i] = "";

        for(int i = 0; i < 5; i++) {
            String t = br.readLine();

            for(int j = 0; j < t.length(); j++)
                inputs[j] += t.charAt(j);
        }

        for(String ss : inputs)
            System.out.print(ss);
    }
}
