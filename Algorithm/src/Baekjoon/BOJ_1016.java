package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1016 {
    public static boolean[] isPrime = new boolean[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] isSquare = new boolean[(int) (max - min + 1)];
        for (long i = 2; i * i <= max; i++) {
            long squared = i * i;
            long j = min % squared == 0 ? min / squared : min / squared + 1;
            for (; j * squared <= max; j++) {
                isSquare[(int) (j * squared - min)] = true;
            }
        }

        int answer = 0;

        for (int i = 0; i <= max - min; i++) {
            if (!isSquare[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
