package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arrayList = new ArrayList<>();

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        arrayList.add(x);
        arrayList.add(y);
        arrayList.add(w - x);
        arrayList.add(h - y);

        Collections.sort(arrayList);

        System.out.println(arrayList.get(0));

        sc.close();
    }
}
