package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        int[] abc = new int[3];

        for(int i = 0; i < 3; i++)
            abc[i] = Integer.parseInt(br.readLine());

        int sum = abc[0] * abc[1] * abc[2];

        while(sum != 0) {
            arr[sum % 10]++;
            sum /= 10;
        }

        for(int i : arr)
            System.out.println(i);
    }
}
