package Baekjoon;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2346 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        List<int[]> list = new LinkedList<>();

        int N = sc.nextInt();
        int index = 0, n = 0;

        for(int i = 1; i <= N; i++)
            list.add(new int[] {sc.nextInt(), i});

        while(!list.isEmpty()) {
            if(n > 0) {
                for(int i = 0; i < n - 1; i++) {
                    index++;
                    if(index >= list.size())
                        index = 0;
                }
            } else {
                for(int i = 0; i < (-1) * n; i++) {
                    index--;
                    if(index < 0)
                        index = list.size() - 1;
                }
            }

            sb.append(list.get(index)[1]).append(' ');
            n = list.remove(index)[0];
            if(index == list.size()) index = 0;
        }

        System.out.println(sb);
    }
}
