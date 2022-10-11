package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), "*");
        String front = st.nextToken();
        String back = st.nextToken();

        while (N-- > 0) {
            String input = br.readLine();

            boolean flag = true;
            boolean[] visit = new boolean[input.length()];

            for (int i = 0; i < front.length(); i++) {
                if (input.charAt(i) != front.charAt(i)) {
                    flag = false;
                    break;
                } else visit[i] = true;
            }

            if (!flag) {
                sb.append("NE").append("\n");
                continue;
            }

            for (int i = input.length() - 1, j = back.length() - 1;
                 i >= input.length() - back.length();
                 i--, j--) {
                if (visit[i] || input.charAt(i) != back.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            sb.append(flag ? "DA" : "NE").append("\n");
        }

        System.out.println(sb);
    }
}
