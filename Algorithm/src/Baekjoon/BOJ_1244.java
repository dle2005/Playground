package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());

        int[] arr = new int[total + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= total; i++) arr[i] = Integer.parseInt(st.nextToken());

        int people = Integer.parseInt(br.readLine());
        while (people-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (sex == 1) {
                for (int i = n; i <= total; i += n) {
                    arr[i] = arr[i] == 1 ? 0 : 1;
                }
            } else {
                int left = n - 1, right = n + 1;

                while (true) {
                    if (left < 1 || right > total) break;
                    if (arr[left] != arr[right]) break;

                    left--;
                    right++;
                }
                left++;
                right--;

                for (int i = left; i <= right; i++) {
                    arr[i] = arr[i] == 1 ? 0 : 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= total; i++) {
            sb.append(arr[i]).append(" ");

            if (i % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }
}
