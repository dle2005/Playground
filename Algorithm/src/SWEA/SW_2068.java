package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int index = 0;

        while (index++ < T) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int max = 0;

            while (st.hasMoreTokens()) max = Math.max(max, Integer.parseInt(st.nextToken()));

            sb.append("#" + index + " " + max + "\n");
        }

        System.out.println(sb);
    }
}
