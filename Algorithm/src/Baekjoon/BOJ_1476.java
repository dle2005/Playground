package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int e = 1, s = 1, m = 1;
        int cnt = 1;

        while (true) {
            if (e == E && s == S && m == M) {
                System.out.println(cnt);
                break;
            }

            if (++e == 16) e = 1;
            if (++s == 29) s = 1;
            if (++m == 20) m = 1;

            cnt++;
        }
    }
}
