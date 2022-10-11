package Baekjoon;

import java.util.Scanner;

public class BOJ_3447 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNextLine()) {
            String s = sc.nextLine();

            while(s.contains("BUG"))
                s = s.replaceAll("(BUG)", "");

            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
