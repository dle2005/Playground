package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_11445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int index = 0;

        while (index++ < T) {
            String first = br.readLine().trim() + "a";
            String second = br.readLine().trim();

            if (first.equals(second)) sb.append("#" + index + " " + "N" + "\n");
            else sb.append("#" + index + " " + "Y" + "\n");
        }

        System.out.println(sb);
    }
}
