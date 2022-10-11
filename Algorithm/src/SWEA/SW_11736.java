package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_11736 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int index = 0;

        while (index++ < T) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            int cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i < N - 1; i++) {
                int min = Math.min(arr[i - 1], Math.min(arr[i], arr[i + 1]));
                int max = Math.max(arr[i - 1], Math.max(arr[i], arr[i + 1]));

                if (arr[i] != min && arr[i] != max) cnt++;
            }

            sb.append("#" + index + " " + cnt + "\n");
        }

        System.out.println(sb);
    }
}
