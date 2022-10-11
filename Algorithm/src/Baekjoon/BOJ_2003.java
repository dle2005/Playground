package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int count = 0;
        for(int low = 0; low < N; low++) {
            int sum = arr[low];
            if(sum == M) {
                count++;
                continue;
            }

            for(int high = low + 1; high < N; high++) {
                if(sum < M)
                    sum += arr[high];
                else
                    break;

                if(sum == M) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
