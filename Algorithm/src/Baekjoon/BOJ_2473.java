package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] numbers = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            numbers[i] = Long.parseLong(st.nextToken());

        Arrays.sort(numbers);

        long dif = Long.MAX_VALUE;

        long l = 0, m = 0, h = 0;

        for (int left = 0; left < N; left++) {
            int mid = left + 1;
            int right = N - 1;

            while (mid < right) {
                long sum = numbers[left] + numbers[mid] + numbers[right];

                if (Math.abs(sum) < dif) {
                    dif = Math.abs(sum);
                    l = numbers[left];
                    m = numbers[mid];
                    h = numbers[right];
                }

                if (sum < 0) mid++;
                else right--;
            }
        }

        System.out.println(l + " " + m + " " + h);
    }
}
