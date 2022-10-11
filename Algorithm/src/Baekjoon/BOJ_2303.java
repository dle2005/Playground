package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2303 {
    public static int max, personMax;
    public static int[] arr = new int[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            personMax = 0;
            combination(0, 0, 0);

            if (max <= personMax) {
                answer = i;
                max = personMax;
            }
        }

        System.out.println(answer);
    }

    public static void combination(int depth, int sum, int idx) {
        if (depth == 3) {
            personMax = Math.max(personMax, sum % 10);

            return;
        }

        for (int i = idx; i < 5; i++) {
            combination(depth + 1, sum + arr[i], i + 1);
        }
    }
}
