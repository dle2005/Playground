package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int index = 0;

        while (index++ < T) {
            st = new StringTokenizer(br.readLine());

            int sum = 0;

            while (st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());

                if (n % 2 == 1) sum += n;
            }

            sb.append("#")
                    .append(index)
                    .append(" ")
                    .append(sum)
                    .append("\n");
        }

        System.out.println(sb);
    }
}
