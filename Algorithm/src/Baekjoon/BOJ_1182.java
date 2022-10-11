package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
    public static int N, S, answer = 0;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        permutation(0, 0);

        System.out.println(S == 0 ? answer - 1 : answer);
    }

    public static void permutation(int depth, int sum) {
        if (depth == N) {
            if(sum == S) answer++;
            return;
        }

        permutation(depth + 1, sum);
        permutation(depth + 1, sum += arr[depth]);
    }

}
