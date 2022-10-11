package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String a = br.readLine();
        String op = br.readLine();
        String b = br.readLine();

        if(op.equals("+")) {
            if(a.length() == b.length()) {
                sb.append(2);
                sb.append(a.substring(1, a.length()));
            }
            else if(a.length() > b.length()) {
                sb.append(a.substring(0, a.length() - b.length()));
                sb.append(b);
            }
            else {
                sb.append(b.substring(0, b.length() - a.length()));
                sb.append(a);
            }
        }
        else {
            sb.append(a);
            sb.append(b.substring(1, b.length()));
        }

        System.out.println(sb);
    }
}
