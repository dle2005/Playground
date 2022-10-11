package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_7490 {
    public static int N;
    public static char[] operator;
    public static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            operator = new char[N];
            list = new ArrayList<>();

            search(1, 0, "1");

            Collections.sort(list);
            for (String s : list) sb.append(s).append("\n");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void search(int n, int o, String s) {
        if (n == N) {
            int sum = 0;

            String temp = s.replaceAll(" ", "");
            StringTokenizer add = new StringTokenizer(temp, "+");
            while (add.hasMoreTokens()) {
                StringTokenizer minus = new StringTokenizer(add.nextToken(), "-");
                int min = 0;
                if (minus.hasMoreTokens()) min += Integer.parseInt(minus.nextToken());
                while (minus.hasMoreTokens()) min -= Integer.parseInt(minus.nextToken());

                sum += min;
            }

            if (sum == 0) list.add(s);
            return;
        }

        operator[o] = '+';
        search(n + 1, o + 1, s + '+' + (n + 1));

        operator[o] = ' ';
        search(n + 1, o + 1, s + ' ' + (n + 1));

        operator[o] = '-';
        search(n + 1, o + 1, s + '-' + (n + 1));
    }
}
