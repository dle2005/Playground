package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[C + 101];
        Arrays.fill(arr, 99999);
        arr[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());

            for (int j = customer; j < C + 101; j++)
                arr[j] = Math.min(arr[j], arr[j - customer] + cost);
        }

        int answer = Integer.MAX_VALUE;
        for (int i = C; i < C + 101; i++)
            answer = Math.min(answer, arr[i]);

        System.out.println(answer);
    }
}
