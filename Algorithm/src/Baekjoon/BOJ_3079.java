package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] times = new int[N];
        for(int i = 0; i < N; i++)
            times[i] = Integer.parseInt(br.readLine());

        long low = 1, high = 1000000000000000000L;
        while (low <= high) {
            long mid = (low + high) / 2;

            long people = 0;

            for(int i = 0; i < N; i++) {
                if(people <= M) people += mid / times[i];
            }

            if(people >= M) high = mid - 1;
            else low = mid + 1;
        }

        System.out.println(low);
    }
}
