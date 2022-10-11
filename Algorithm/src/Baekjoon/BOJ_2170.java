package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2170 {
    public static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) return this.y - o.y < 0 ? -1 : 1;
            else return this.x - o.x < 0 ? -1 : 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Point> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Point(x, y));
        }

        Collections.sort(list);

        long start = list.get(0).x;
        long end = list.get(0).y;
        long sum = end - start;

        for (int i = 1; i < list.size(); i++) {
            long n_start = list.get(i).x;
            long n_end = list.get(i).y;

            if (start <= n_start && n_end <= end) continue;
            else if (n_start < end) sum += -(end - n_start) + n_end - n_start;
            else sum += n_end - n_start;

            start = n_start;
            end = n_end;
        }

        System.out.println(sum);
    }
}
