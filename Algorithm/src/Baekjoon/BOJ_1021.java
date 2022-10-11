package Baekjoon;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();

        int N = sc.nextInt();
        int M = sc.nextInt();

        int count = 0;

        for(int i = 1; i <= N; i++)
            list.add(i);

        for(int i = 0; i < M; i++) {
            int m = sc.nextInt();

            while(true) {
                if(list.get(0) == m) {
                    list.remove(0);
                    break;
                }
                else {
                    if (list.indexOf(m) <= list.size() / 2)
                        list.add(list.size() - 1, list.remove(0));
                    else
                        list.add(0, list.remove(list.size() - 1));
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
