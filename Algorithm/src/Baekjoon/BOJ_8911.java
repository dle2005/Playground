package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

        while (T-- > 0) {
            String order = br.readLine();
            int x1, x2, y1, y2, x, y, d;
            x1 = x2 = y1 = y2 = x = y = d = 0;

            for (int i = 0; i < order.length(); i++) {
                char c = order.charAt(i);

                if (c == 'L') d = (d + 1) % 4;
                else if (c == 'R') d = (d - 1 + 4) % 4;
                else if (c == 'F') {
                    y += dir[d][0];
                    x += dir[d][1];
                } else if (c == 'B') {
                    y -= dir[d][0];
                    x -= dir[d][1];
                }

                y1 = Math.max(y1, y);
                y2 = Math.min(y2, y);
                x1 = Math.max(x1, x);
                x2 = Math.min(x2, x);
            }

            int h = y1 - y2;
            int w = x1 - x2;

            sb.append(h * w).append("\n");
        }

        System.out.println(sb);
    }
}
