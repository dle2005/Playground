package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2548 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            set.add(arr[i]);
        }

        int minDiff = Integer.MAX_VALUE, answer = Integer.MAX_VALUE;
        for (int candidate : set) {
            int diff = 0;
            for (int n : arr) {
                diff += Math.abs(candidate - n);
            }

            if (diff < minDiff) {
                minDiff = diff;
                answer = candidate;
            } else if (diff == minDiff) {
                answer = Math.min(answer, candidate);
            }
        }

        System.out.println(answer);
    }
}
