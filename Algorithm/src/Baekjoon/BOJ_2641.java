package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2641 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder forward = new StringBuilder();
        StringBuilder reverse = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String t = st.nextToken();

            forward.append(t);
            reverse.insert(0, reverse(t));
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(forward.toString());
            set.add(reverse.toString());

            forward.append(forward.charAt(0));
            reverse.append(reverse.charAt(0));

            forward.deleteCharAt(0);
            reverse.deleteCharAt(0);
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            StringBuilder t = new StringBuilder();

            for (int j = 0; j < N; j++) {
                t.append(st.nextToken());
            }

            if (set.contains(t.toString())) {
                cnt++;
                for (int j = 0; j < N; j++) {
                    sb.append(t.charAt(j)).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }

    public static String reverse(String s) {
        switch (s) {
            case "1":
                return "3";
            case "2":
                return "4";
            case "3":
                return "1";
            default:
                return "2";
        }
    }
}
