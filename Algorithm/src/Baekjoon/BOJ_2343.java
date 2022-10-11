package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] videos = new int[N];
        int low = Integer.MIN_VALUE, high = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            videos[i] = Integer.parseInt(st.nextToken());
            low = Math.max(low, videos[i]);
            high += videos[i];
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 1, sum = 0;

            for (int i = 0; i < N; i++) {
                if (sum + videos[i] > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += videos[i];
            }

            if(cnt <= M) high = mid - 1;
            else low = mid + 1;
        }

        System.out.println(low);
    }
}
