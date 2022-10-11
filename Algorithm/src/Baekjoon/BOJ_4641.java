package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4641 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();

            if(s.equals("-1")) break;

            boolean[] numbers = new boolean[101];
            int cnt = 0;

            StringTokenizer st = new StringTokenizer(s, " ");
            int[] arr = new int[st.countTokens()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                numbers[arr[i]] = true;
            }

            for (int n : arr) {
                if (n % 2 == 0 && n != 0 && numbers[n / 2]) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
