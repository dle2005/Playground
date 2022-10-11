package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_6443 {
    public static char[] arr, permutation;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            arr = br.readLine().toCharArray();
            Arrays.sort(arr);

            permutation = new char[arr.length];
            visit = new boolean[arr.length];

            backTracking(0);
        }

        System.out.println(sb);
    }

    public static void backTracking(int depth) {
        if (depth == arr.length) {
            sb.append(permutation).append("\n");
            return;
        }

        permutation[depth] = 0;
        for (int i = 0; i < arr.length; i++) {
            if (visit[i]) continue;
            if (permutation[depth] >= arr[i]) continue;

            visit[i] = true;
            permutation[depth] = arr[i];
            backTracking(depth + 1);
            visit[i] = false;
        }
    }
}
