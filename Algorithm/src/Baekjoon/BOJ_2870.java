package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<BigInteger> list = new ArrayList<>();

        while (N-- > 0) {
            String[] s = br.readLine().split("\\D");

            for (int i = 0; i < s.length; i++) {
                if (!s[i].equals("")) list.add(new BigInteger(s[i]));
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (BigInteger n : list) sb.append(n).append("\n");

        System.out.println(sb);
    }
}
