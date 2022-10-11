package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 전체 용액의 수 N

        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        long dif = Integer.MAX_VALUE;
        long neg = 0, pos = 0;
        int low = 0, high = N-1;
        while(low < high) {
            long sum = arr[low] + arr[high];

            if(Math.abs(sum) < dif) {
                neg = arr[low];
                pos = arr[high];

                dif = Math.abs(sum);
            }

            if (sum > 0)
                high--;
            else
                low++;
        }

        System.out.println(neg + " " + pos);
    }
}
