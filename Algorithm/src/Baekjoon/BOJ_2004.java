package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long five_cnt = powerFive(n) - powerFive(n - m) - powerFive(m);
        long two_cnt = powerTwo(n) - powerTwo(n - m) - powerTwo(m);

        System.out.println(Math.min(five_cnt, two_cnt));
    }

    public static int powerFive(long n) {
        int cnt = 0;

        while (n >= 5) {
            cnt += n / 5;
            n /= 5;
        }

        return cnt;
    }

    public static int powerTwo(long n) {
        int cnt = 0;

        while (n >= 2) {
            cnt += n / 2;
            n /= 2;
        }

        return cnt;
    }
}
