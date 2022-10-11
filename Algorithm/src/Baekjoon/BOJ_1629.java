package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    public static long pow(long A, long e, long C) {
        if (e == 0) {
            return 1;
        }

        long n = pow(A, e / 2, C);

        if (e % 2 == 0) {
            return n * n % C;
        } else {
            return (n * n % C) * A % C;
        }
    }
}
