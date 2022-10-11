package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1517 {
    public static int answer;
    public static long[] sort_arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        sort_arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            arr[i] = Long.parseLong(st.nextToken());

        mergeSort(arr, 0, N - 1);

        System.out.println(answer);
    }

    public static void mergeSort(long[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(long[] arr, int low, int mid, int high) {
        int p = low;
        int q = mid + 1;
        int idx = low;

        while (p <= mid && q <= high) {
            if (arr[p] <= arr[q]) {
                sort_arr[idx++] = arr[p++];
            } else {
                sort_arr[idx++] = arr[q++];
                answer += (mid + 1 - p);
            }
        }

        while (p <= mid)
            sort_arr[idx++] = arr[p++];

        while (q <= high)
            sort_arr[idx++] = arr[q++];

        for (int i = low; i <= high; i++)
            arr[i] = sort_arr[i];
    }
}
