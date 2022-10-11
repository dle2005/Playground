package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10815 {
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);

        int M = sc.nextInt();

        for(int i = 0; i < M; i++)
            sb.append(bSearch(sc.nextInt())).append(" ");

        System.out.println(sb);
    }

    public static int bSearch(int n) {
        int low = 0, high = arr.length -1;
        int mid = (low + high) / 2;

        while(low <= high) {
            if(arr[mid] == n)
                return 1;
            else if(arr[mid] > n) {
                high = mid - 1;
                mid = (low + high) / 2;
            }
            else {
                low = mid + 1;
                mid = (low + high) / 2;
            }
        }

        return 0;
    }
}
