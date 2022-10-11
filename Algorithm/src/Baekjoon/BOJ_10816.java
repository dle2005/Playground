package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st;

        Set<Integer> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(map.containsKey(n))
                map.put(n, map.get(n)+1);
            else
                map.put(n, 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            int m = Integer.parseInt(st.nextToken());
            if(map.containsKey(m))
                sb.append(map.get(m)).append(" ");
            else
                sb.append(0).append(" ");
        }

        System.out.println(sb);
    }
}
