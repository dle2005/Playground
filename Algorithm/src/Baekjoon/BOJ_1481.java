package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1481 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        List<Integer> below = new ArrayList<>();
        List<Integer> above = new ArrayList<>();
        below.add(0);
        above.add(0);

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n < 0) below.add(n);
            else above.add(n);
        }

        Collections.sort(below);
        Collections.sort(above, Collections.reverseOrder());

        int under = 0, over = 0, answer;

        if (Math.abs(below.get(0)) < above.get(0)) {
            answer = above.get(over);
            over += M;
        }
        else {
            answer = Math.abs(below.get(under));
            under += M;
        }

        while (over < above.size()) {
            answer += above.get(over) * 2;
            over += M;
        }

        while (under < below.size()) {
            answer += Math.abs(below.get(under)) * 2;
            under += M;
        }

        System.out.println(answer);
    }
}
