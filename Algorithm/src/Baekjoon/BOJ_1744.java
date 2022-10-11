package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];

        int minus = 0;
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            if (numbers[i] <= 0) minus++;
        }

        Arrays.sort(numbers);

        int answer = 0;

        for (int i = 0; i < minus - minus % 2; i += 2)
            answer += numbers[i] * numbers[i + 1];
        if (minus % 2 == 1) answer += numbers[minus - 1];

        for (int i = N - 1; i > minus; i -= 2) {
            if(numbers[i] == 1 || numbers[i - 1] == 1)
                answer += numbers[i] + numbers[i - 1];
            else answer += numbers[i] * numbers[i - 1];
        }
        if ((N - minus) % 2 == 1) answer += numbers[minus];

        System.out.println(answer);
    }
}
