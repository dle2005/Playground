package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer>[] matrix = new List[2];
        matrix[0] = new ArrayList<>();
        matrix[1] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        matrix[1].add(Integer.parseInt(st.nextToken()));
        matrix[0].add(Integer.parseInt(st.nextToken()));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            int idx = 0;
            for (; pos - matrix[d].get(idx) > 0; idx++) {
                pos -= matrix[d].get(idx);
            }

            int remove = matrix[d].remove(idx);
            matrix[d].add(idx, remove - pos);
            matrix[d].add(idx, pos);
        }

        int answer = 0;
        for (int r : matrix[0]) {
            for (int c : matrix[1]) {
                answer = Math.max(answer, r * c);
            }
        }

        System.out.println(answer);
    }
}
