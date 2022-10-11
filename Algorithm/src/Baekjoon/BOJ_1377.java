package Baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Point[] A = new Point[N];
        for (int i = 0; i < N; i++) {
            A[i] = new Point(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(A, Comparator.comparingInt(o -> o.x));

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, A[i].y - i);
        }

        System.out.println(max + 1);
    }
}
