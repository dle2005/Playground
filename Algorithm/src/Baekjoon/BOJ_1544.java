package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1544 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        while (N-- > 0){
            StringBuilder sb = new StringBuilder(br.readLine());
            boolean flag = false;
            for (int i = 0; i < sb.length(); i++) {
                if (set.contains(sb.toString())) {
                    flag = true;
                    break;
                }

                sb = sb.append(sb.charAt(0)).deleteCharAt(0);
            }

            if (!flag) set.add(sb.toString());
        }

        System.out.println(set.size());
    }
}
