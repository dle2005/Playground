package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 1, right = arr[arr.length-1] - arr[0];
        int mid = 0, max_distance = 0;

        while(left <= right) {
            mid = (left + right) / 2;
            int from = arr[0];
            int house = 1;

            for(int i = 1; i < N; i++) {
                int dist = arr[i] - from;
                if(mid <= dist) {
                    house++;
                    from = arr[i];
                }
            }

            if(house >= C) {
                max_distance = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }

        System.out.println(max_distance);
    }
}
