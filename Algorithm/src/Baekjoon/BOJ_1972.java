package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s.equals("*")) break;

            sb.append(s);
            if (isSurprising(s)) sb.append(" is surprising.");
            else sb.append(" is NOT surprising.");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static boolean isSurprising(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            Set<String> set = new HashSet<>();

            for (int j = 0; j < s.length() - (i + 1); j++) {
                String t = s.charAt(j) + "" + s.charAt(j + (i + 1));

                if (set.contains(t)) return false;
                else set.add(t);
            }
        }

        return true;
    }
}
