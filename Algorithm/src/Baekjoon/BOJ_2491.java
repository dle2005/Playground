package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] increase = new int[N];
        int[] decrease = new int[N];

        Arrays.fill(increase, 1);
        Arrays.fill(decrease, 1);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int max = 1;

        for (int i = 1; i < N; i++) {
            if(arr[i-1] <= arr[i])
                increase[i] = increase[i - 1] + 1;

            max = Math.max(max, increase[i]);
        }

        for (int i = N - 2; i >= 0; i--) {
            if(arr[i] >= arr[i+1])
                decrease[i] = decrease[i+1] + 1;

            max = Math.max(max, decrease[i]);
        }

        System.out.println(max);
    }
}
