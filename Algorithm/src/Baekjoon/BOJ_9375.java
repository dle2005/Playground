package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Map<String, Integer> map = new HashMap<>();

            int n = Integer.parseInt(br.readLine());

            for(int j = 0; j < n; j++) {
                String s = br.readLine().split(" ")[1];

                if(map.containsKey(s))
                    map.put(s, map.get(s) + 1);
                else map.put(s, 1);
            }

            int answer = 1;
            for(int c : map.values())
                answer *= (c + 1);

            sb.append(answer - 1).append("\n");
        }

        System.out.println(sb);
    }
}
