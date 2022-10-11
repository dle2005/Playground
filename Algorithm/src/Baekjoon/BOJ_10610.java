package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        if(!s.contains("0")) {
            System.out.println(-1);
            return;
        }

        int sum = 0;
        for(int i = 0; i < s.length(); i++)
            sum += s.charAt(i);

        if(sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        String answer = "";

        for(int i = s.length()-1; i >= 0; i--)
            answer += arr[i];

        System.out.println(answer);
    }
}
