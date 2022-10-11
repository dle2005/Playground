package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2071 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int index = 0;

        while (index++ < T) {
            st = new StringTokenizer(br.readLine());

            int avg = 0;

            while (st.hasMoreTokens()) avg += Integer.parseInt(st.nextToken());

            sb.append("#" + index + " " + Math.round(avg / 10.0) + "\n");
        }

        System.out.println(sb);
    }
}
