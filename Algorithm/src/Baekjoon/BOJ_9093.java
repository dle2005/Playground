package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            while(st.hasMoreTokens()) {
                StringBuilder sb = new StringBuilder(st.nextToken());
                sb = sb.reverse();

                result.append(sb).append(" ");
            }
            result.append("\n");
        }

        System.out.println(result);
    }
}
