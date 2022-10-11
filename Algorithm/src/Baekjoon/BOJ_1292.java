package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[B + 1];
        int cur = 1, cnt = 0;
        int sum = 0;

        for (int i = 0; i < B; i++) {
            arr[i] = cur;
            cnt++;

            if (cnt == cur) {
                cnt = 0;
                cur++;
            }

            if(A - 1 <= i) sum += arr[i];
        }

        System.out.println(sum);
    }
}
