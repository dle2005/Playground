package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2711 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int index = Integer.parseInt(st.nextToken());
            StringBuilder s = new StringBuilder(st.nextToken());

            s.deleteCharAt(index - 1);
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
