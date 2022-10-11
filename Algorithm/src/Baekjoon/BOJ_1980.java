package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int a = Math.min(n, m);
        int b = Math.max(n, m);

        int max = t / a; // 18
        int coke = t % a; // 1
        int min = 0;

        int burger = max;

        while (max >= 0) {
            int value = max * a + min * b;
            int rest = t - value;

            if (rest >= 0 && coke > rest) {
                coke = rest;
                burger = max + min;
            }

            max--;
            if(value - a + b <= t) min++;
        }

        System.out.println(burger + " " + coke);
    }
}
