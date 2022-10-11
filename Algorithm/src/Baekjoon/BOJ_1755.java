package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1755 {
    public static class Number implements Comparable<Number> {
        String s;
        int n;

        public Number(String s, int n) {
            this.s = s;
            this.n = n;
        }

        @Override
        public int compareTo(Number o) {
            return this.s.compareTo(o.s);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Number[] num = new Number[N - M + 1];

        for (int i = M; i <= N; i++) {
            String s = String.valueOf(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++)
                sb.append(change(s.charAt(j) - '0')).append(" ");
            num[i - M] = new Number(sb.toString(), i);
        }

        Arrays.sort(num);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length; i++) {
            if (i != 0 && i % 10 == 0) sb.append("\n");
            sb.append(num[i].n).append(" ");
        }

        System.out.println(sb);
    }

    public static String change(int n) {
        switch (n) {
            case 0 : return "zero";
            case 1 : return "one";
            case 2 : return "two";
            case 3 : return "three";
            case 4 : return "four";
            case 5 : return "five";
            case 6 : return "six";
            case 7 : return "seven";
            case 8 : return "eight";
            case 9 : return "nine";
        }
        return "";
    }
}
