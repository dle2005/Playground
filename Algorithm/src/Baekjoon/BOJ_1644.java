package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }
        
        boolean[] prime = new boolean[N + 1];
        for (int i = 2; i * i <= N; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= N; j += i)
                    prime[j] = true;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (!prime[i]) list.add(i);
        }

        int cnt = 0, sum = 0, front = 0, back = 0;
        while (true) {
            if (sum < N) sum += list.get(back++);
            else if (sum >= N) sum -= list.get(front++);

            if (sum == N) cnt++;

            if (back == list.size() && back - 1 == front) break;
        }

        System.out.println(cnt);
    }

}
