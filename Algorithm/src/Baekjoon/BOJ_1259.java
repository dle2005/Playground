package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if(s.equals("0")) break;

            int low = 0, high = s.length()-1;
            boolean flag = true;

            while (low <= high) {
                if(s.charAt(low) != s.charAt(high)) {
                    flag = false;
                    break;
                }
                
                low++; high--;
            }

            if(flag) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }

        System.out.println(sb);
    }
}
