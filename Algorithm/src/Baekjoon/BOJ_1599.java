package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1599 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().replace('k', 'c').replace("ng", "n~");
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            arr[i] = arr[i].replace('c', 'k').replace("n~", "ng");
            System.out.println(arr[i]);
        }
    }
}
