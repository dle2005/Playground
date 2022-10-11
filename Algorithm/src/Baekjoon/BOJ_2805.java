package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        long max = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        long low = 1, high = max;
        while(low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;

            for(int i = 0; i < N; i++)
                sum += Math.max(arr[i] - mid, 0);

            if(sum >= M)
                low = mid + 1;
            else
                high = mid - 1;
        }

        System.out.println(high);
    }
}
