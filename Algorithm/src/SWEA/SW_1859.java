package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int index = 0;

        while (index++ < T) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            long sum = 0;
            int max = arr[N - 1];

            for (int i = N - 2; i >= 0; i--) {
                if (arr[i] < max) sum += max - arr[i];
                else if (arr[i] > max) max = arr[i];
            }

            sb.append("#" + index + " " + sum + "\n");
        }

        System.out.println(sb);
    }
}
