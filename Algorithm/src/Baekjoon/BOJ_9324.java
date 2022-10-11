package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9324 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String s = br.readLine();

            int[] alp = new int[26];
            StringBuilder temp = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                temp.append(s.charAt(i));
                if (++alp[s.charAt(i) - 'A'] % 3 == 0){ 
                    temp.append(s.charAt(i++));
                }
            }


            sb.append(s.equals(temp.toString()) ? "OK" : "FAKE").append("\n");
        }

        System.out.println(sb);
    }
}
