package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        int max = 0;

        for(int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if(t > max) max = t;
            list.add(t);
        }

        int[] arr = new int[max + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for(int i = 4; i <= max; i++)
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];

        for(int i : list)
            System.out.println(arr[i]);

    }
}
