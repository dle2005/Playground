package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[A];
            for (int i = 0; i < A; i++) arr[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] brr = new int[B];
            for (int i = 0; i < B; i++) brr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(brr);

            int cnt = 0;

            for (int i = 0; i < A; i++) {
                int low = 0, high = B - 1;

                while (low <= high) {
                    int mid = (low + high) / 2;

                    if (arr[i] > brr[mid]) low = mid + 1;
                    else high = mid - 1;
                }

                cnt += low;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
