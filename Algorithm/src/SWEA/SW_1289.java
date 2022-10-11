package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int index = 0;

        while (index++ < T) {
            String s = br.readLine();

            int cnt = 0;
            char bit = '0';

            for (char c : s.toCharArray()) {
                if (c != bit) {
                    bit = c;
                    cnt++;
                }
            }

            sb.append("#" + index + " " + cnt + "\n");
        }

        System.out.println(sb);
    }
}
