package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_11688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int index = 0;

        while (index++ < T) {
            String s = br.readLine();

            int a = 1, b = 1;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'L') b = a + b;
                else a = a + b;
            }

            sb.append("#" + index + " " + a + " " + b + "\n");
        }

        System.out.println(sb);
    }
}
