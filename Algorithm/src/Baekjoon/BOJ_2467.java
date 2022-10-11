package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        int left = 0, right = N - 1;
        int low = 0, high = 0;
        int dif = Integer.MAX_VALUE;

        while (left < right) {
            int d = Math.abs(numbers[left] + numbers[right]);

            if (d == 0) {
                low = numbers[left];
                high = numbers[right];
                break;
            }

            if (dif > d) {
                dif = d;
                low = numbers[left];
                high = numbers[right];
            }

            if(Math.abs(numbers[left]) > Math.abs(numbers[right]))
                left++;
            else right --;
        }

        System.out.println(low + " " + high);
    }
}
