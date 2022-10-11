package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        StringBuilder x = new StringBuilder(st.nextToken());
        StringBuilder y = new StringBuilder(st.nextToken());

        x = x.reverse();
        y = y.reverse();

        int xy = Integer.parseInt(x.toString()) + Integer.parseInt(y.toString());

        StringBuilder result = new StringBuilder(String.valueOf(xy));
        result = result.reverse();

        System.out.println(Integer.parseInt(result.toString()));
    }
}
