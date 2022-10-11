package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J_562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[10];
        int sum = 0;
        double avg = 0;

        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (i % 2 == 1) sum += arr[i];
            else avg += arr[i];
        }

        System.out.println("sum : " + sum);
        System.out.println("avg : " + (double) Math.round(avg / 5 * 100) / 100);
    }
}
