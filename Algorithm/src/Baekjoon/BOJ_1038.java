package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1038 {
    public static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N <= 10) {
            System.out.println(N);
            return;
        }

        for (int i = 0; i < 10; i++) decreasingNum(i, 1);

        Collections.sort(list);

        if(list.size() <= N) System.out.println(-1);
        else System.out.println(list.get(N));
    }

    public static void decreasingNum(long num, int depth) {
        if (depth > 10) return;

        list.add(num);

        for (int i = 0; i < 10; i++) {
            if(num % 10 > i) decreasingNum(num * 10 + i, depth + 1);
        }

        return;
    }

}
