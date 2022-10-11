package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[] input = new String[R];

        String answer = "";

        for (int i = 0; i < R; i++) {
            input[i] = br.readLine();

            st = new StringTokenizer(input[i], "#");
            while (st.hasMoreTokens()) {
                String t = st.nextToken();

                if (t.length() >= 2) {
                    if (answer == "" || answer.compareTo(t) > 0) answer = t;
                }
            }
        }

        for (int i = 0; i < C; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < R; j++) sb.append(input[j].charAt(i));

            st = new StringTokenizer(String.valueOf(sb), "#");
            while (st.hasMoreTokens()) {
                String t = st.nextToken();

                if (t.length() >= 2) {
                    if (answer == "" || answer.compareTo(t) > 0) answer = t;
                }
            }
        }

        System.out.println(answer);
    }
}
