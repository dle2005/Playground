package Baekjoon;

import java.util.Scanner;

public class BOJ_2750 {
    static int[] sorted_list = new int[1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] input = new int[n];

        for(int i = 0; i < n; i++)
            input[i] = sc.nextInt();

        merge_sort(input, 0, n-1);

        for(int i = 0; i < n; i++)
            System.out.println(input[i]);
    }
    public static void merge_sort(int[] list, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            merge_sort(list, left, mid);
            merge_sort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }
    public static void merge(int[] list, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while(i <= mid && j <= right) {
            if(list[i] <= list[j])
                sorted_list[k++] = list[i++];
            else
                sorted_list[k++] = list[j++];
        }

        if(i > mid) {
            for (int r = j; r <= right; r++)
                sorted_list[k++] = list[r];
        }
        else {
            for(int r = i; r <= mid; r++)
                sorted_list[k++] = list[r];
        }

        for(int r = left; r <= right; r++)
            list[r] = sorted_list[r];
    }
}
