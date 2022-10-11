package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            boolean flag = true;
            int n = i;

            while (n > 0) {
                if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9) {
                    flag = false;
                    sb.append("-");
                }
                n /= 10;
            }

            if (flag) sb.append(i);

            sb.append(" ");
        }

        System.out.println(sb);
    }
}
