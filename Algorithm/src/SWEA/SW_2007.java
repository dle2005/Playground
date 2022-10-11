package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_2007 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int index = 0;

        while (index++ < T) {
            String s = br.readLine();

            for (int i = 1; i < s.length() / 2; i++) {
                String first = s.substring(0, i);
                String second = s.substring(i, i + i);

                if (first.equals(second)) {
                    sb.append("#" + index + " " + first.length() + "\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
