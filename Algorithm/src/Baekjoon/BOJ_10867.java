package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            if (!set.contains(n)) {
                set.add(n);
                list.add(n);
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (int n : list) sb.append(n + " ");

        System.out.println(sb);
    }
}
