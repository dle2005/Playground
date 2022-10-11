package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            int sum = 0;

            for (int i = 0; i < N; i++) {

                int max = 0;
                for (int j = Math.max(0, i - 2); j < Math.min(N, i + 3); j++) {
                    if (i == j) continue;

                    max = Math.max(max, arr[j]);
                }

                if (arr[i] > max) sum += arr[i] - max;

            }

            sb.append("#" + t + " " + sum + "\n");
        }

        System.out.println(sb);
    }
}
