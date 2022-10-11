package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BOJ_1501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            s = sort(s);

            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        StringBuilder answer = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] sentence = br.readLine().split(" ");

            int case_num = 1;

            for (String word : sentence) {
                word = sort(word);

                case_num *= map.getOrDefault(word, 1);
            }

            answer.append(case_num).append("\n");
        }

        System.out.println(answer);
    }

    public static String sort(String s) {
        if (s.length() >= 3) {
            char[] chars = s.substring(1, s.length() - 1).toCharArray();
            Arrays.sort(chars);

            s = s.charAt(0) + Arrays.toString(chars) + s.charAt(s.length() - 1);
        }

        return s;
    }
}
