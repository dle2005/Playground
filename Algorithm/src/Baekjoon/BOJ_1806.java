package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        int low = 0, high = 0;
        int answer = Integer.MAX_VALUE, sum = 0;

        while (high < N) {
            if (sum < S && high < N) {
                sum += numbers[high];
                high++;
            }

            while (S <= sum) {
                int length = high - low;
                answer = Math.min(answer, length);

                sum -= numbers[low];
                low++;
            }

        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
