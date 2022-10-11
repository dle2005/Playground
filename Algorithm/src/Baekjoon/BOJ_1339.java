package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] alpha = new int[27];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++)
                alpha[s.charAt(j)-'A'] += Math.pow(10, s.length()-j-1);
        }

        Arrays.sort(alpha);

        int sum = 0, num = 9;

        for(int i = alpha.length-1; i >= 0; i--) {
            if(alpha[i] == 0)
                break;

            sum += alpha[i] * num;
            num--;
        }

        System.out.println(sum);
    }
}
