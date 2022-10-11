package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) set.add(Integer.parseInt(st.nextToken()));

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                int t = Integer.parseInt(st.nextToken());

                if (set.contains(t)) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }
        }

        System.out.println(sb);
    }
}
