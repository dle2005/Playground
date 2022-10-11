package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_11387 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int index = 0;

        while (index++ < T) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            double L = Double.parseDouble(st.nextToken()) / 100;
            int N = Integer.parseInt(st.nextToken());

            double damage = 0;
            for (int i = 0; i < N; i++)
                damage += (D * (1 + i * L));
            int d = (int) damage;

            sb.append("#" + index + " " + d + "\n");
        }

        System.out.println(sb);
    }
}
