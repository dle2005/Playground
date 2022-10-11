package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_2512 {
    public static List<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();

        int sum = 0;
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            int n = sc.nextInt();
            sum += n;
            list.add(n);
        }
        int M = sc.nextInt();

        Collections.sort(list);

        if(sum <= M) {
            System.out.println(list.get(list.size()-1));
            return;
        }

        int low = 0, high = list.get(list.size()-1);
        int mid = (low + high) / 2;

        while(mid != low) {
            sum = 0;

            for(int i : list)
                sum += mid <= i ? mid : i;

            if(sum <= M)
                low = mid;
            else
                high = mid;

            mid = (low + high) / 2;
        }


        System.out.println(mid);
    }
}
