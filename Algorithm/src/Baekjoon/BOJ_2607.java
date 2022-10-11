package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String first = br.readLine();
        int[] alp = new int[26];
        for (int i = 0; i < first.length(); i++) alp[first.charAt(i)-'A']++;

        int answer = 0;

        for (int i = 1; i < N; i++) {
            String next = br.readLine();

            int[] temp = alp.clone();

            int cnt = 0;
            for (int j = 0; j < next.length(); j++) {
                if (temp[next.charAt(j) - 'A'] > 0) {
                    cnt++;
                    temp[next.charAt(j) - 'A']--;
                }
            }

            if (first.length() == next.length() && (cnt == first.length() || cnt == first.length() - 1)) answer++;
            else if (first.length() - 1 == next.length() && cnt == next.length()) answer++;
            else if (first.length() + 1 == next.length() && cnt == first.length()) answer++;
        }

        System.out.println(answer);
    }
}
