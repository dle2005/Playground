package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] list = new int[n];
        for(int i = 0; i < n; i++)
            list[i] = Integer.parseInt(br.readLine());

        Arrays.sort(list);

        double avg = avg(list, n);
        int mid = mid(list, n);
        int mos = most(list, n);
        int range = range(list, n);

        System.out.println((int)(Math.round(avg)));
        System.out.println(mid);
        System.out.println(mos);
        System.out.println(range);
    }
    public static int range(int[] list, int n) {
        int min = 4001, max = -4001;

        for(int i = 0; i < n; i++) {
            if(list[i] < min) min = list[i];
            if(list[i] > max) max = list[i];
        }

        if(min == max) return 0;
        else if(min < 0 && max > 0) return Math.abs(min) + max;
        else if(min < 0 && max < 0) return Math.abs(Math.abs(min) + max);
        else return min + max;
    }
    public static int most(int[] list, int n) {
        int[] count = new int[8001];
        int max = 1, value = 0;

        for(int i = 0; i < n; i++) {
            if (list[i] < 0) count[Math.abs(list[i])]++;
            else count[list[i]+4000]++;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < 8001; i++)
            if(max < count[i]) max = count[i];

        for(int i = 0; i < 8001; i++) {
            if (max == count[i]) {
                if(i > 4000) value = i - 4000;
                else value = i * (-1);
                arrayList.add(value);
            }
        }

        Collections.sort(arrayList);

        if(arrayList.size() > 1) return arrayList.get(1);
        else return arrayList.get(0);
    }
    public static int mid(int[] list, int n) {
        return list[n / 2];
    }
    public static double avg(int[] list, int n) {
        double sum = 0;
        double avg = 0.0;

        for(int i = 0; i < n; i++)
            sum += list[i];

        avg = sum / n;

        return avg;
    }
}
