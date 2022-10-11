package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int N = sc.nextInt();

        for(int i = 0; i < N; i++)
            list.add(sc.nextInt());

        Collections.sort(list, Collections.reverseOrder());

        int max = 0;
        for(int i = 0; i < N; i++) {
            if(max < list.get(i) * (i+1))
                max = list.get(i) * (i+1);
        }

        System.out.println(max);
    }
}
