package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819 {
    public static int N, answer;
    public static int[] numbers, permutation;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        permutation = new int[N];
        visit = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        backtracking(0);

        System.out.println(answer);
    }

    public static void backtracking(int depth) {
        if (depth == N) {
            answer = Math.max(answer, calculation());
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                permutation[depth] = numbers[i];
                backtracking(depth + 1);
                visit[i] = false;
            }
        }
    }

    public static int calculation() {
        int result = 0;

        for (int i = 0; i < N - 1; i++)
            result += Math.abs(permutation[i] - permutation[i + 1]);

        return result;
    }
}
