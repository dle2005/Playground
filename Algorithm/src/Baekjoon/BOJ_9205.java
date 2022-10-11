package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {
    public static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            Pos[] pos = new Pos[n + 2];
            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                pos[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Pos start = pos[0];
            Pos dest = pos[n + 1];
            boolean[] visit = new boolean[n + 2];
            boolean flag = false;

            Queue<Pos> queue = new LinkedList<>();
            queue.add(start);

            while (!queue.isEmpty()) {
                Pos cur = queue.poll();

                if (cur.equals(dest)) {
                    flag = true;
                    break;
                }

                for (int i = 1; i < n + 2; i++) {
                    if (visit[i]) continue;

                    if ((Math.abs(cur.x - pos[i].x) + Math.abs(cur.y - pos[i].y)) <= 1000) {
                        queue.add(pos[i]);
                        visit[i] = true;
                    }
                }
            }

            sb.append(flag ? "happy" : "sad").append("\n");
        }

        System.out.println(sb);
    }
}
