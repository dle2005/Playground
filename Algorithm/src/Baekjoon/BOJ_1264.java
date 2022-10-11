package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String regex = "(a|e|i|o|u|A|E|I|O|U)";

        while (true) {
            String s = br.readLine();

            if(s.equals("#")) break;

            int cnt = 0;
            for(int i = 0; i < s.length(); i++) {
                if (String.valueOf(s.charAt(i)).matches(regex)) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
