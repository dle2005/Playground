package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(br.readLine());

        int pair = 0;

        Arrays.sort(arr);

        int low = 0, high = arr.length-1;
        while(low < high) {
            if(arr[low] + arr[high] == x)
                pair++;

            if(arr[low] + arr[high] > x)
                high--;
            else
                low++;
        }

        System.out.println(pair);
    }
}
