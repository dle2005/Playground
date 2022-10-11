package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        char[] N = st.nextToken().toCharArray();
        int B = Integer.parseInt(st.nextToken());

        int answer = 0;

        for (int i = 0; i < N.length; i++) {
            char c = N[i];

            if (Character.isAlphabetic(c))
                answer = answer * B + (c - 'A' + 10);
            else
                answer = answer * B + (c - '0');
        }

        System.out.println(answer);
    }
}
