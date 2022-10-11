package Baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_1212 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String[] eight = {"000","001","010","011","100","101","110","111"};
        
        String s = sc.nextLine();
        boolean flag = true;

        if (s.length() == 1 && s.charAt(0) == '0') {
            sb.append(0);
        }

        for (int i = 0; i < s.length(); i++) {
            int n = Integer.parseInt(s.substring(i, i + 1));
            if (flag && n < 4) {
                if (n == 0) continue;
                else if (n == 1) sb.append("1");
                else if (n == 2) sb.append("10");
                else if (n == 3) sb.append("11");
            }
            else sb.append(eight[n]);
            flag = false;
        }

        System.out.println(sb);
    }
}
