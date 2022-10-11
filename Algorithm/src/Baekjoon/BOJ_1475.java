package Baekjoon;

import java.util.Scanner;

public class BOJ_1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int[] arr = new int[10];

        for(int i = 0; i < s.length(); i++)
            arr[Integer.parseInt(String.valueOf(s.charAt(i)))]++;

        arr[6] = arr[9] = (int) Math.ceil((arr[6] + arr[9]) / 2.0);

        int max = 0;
        for(int i : arr)
            max = Math.max(max, i);

        System.out.println(max);
    }
}
