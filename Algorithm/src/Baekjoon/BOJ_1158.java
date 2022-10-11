package Baekjoon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();

        int N = sc.nextInt();
        int K = sc.nextInt();

        for(int i = 1; i <= N; i++)
            deque.offer(i);

        for(int i = 0; i < N -1; i++) {
            for(int j = 0; j < K - 1; j++)
                deque.offer(deque.poll());

            sb.append(deque.poll()).append(", ");
        }
        sb.append(deque.poll());

        System.out.print("<");
        System.out.print(sb);
        System.out.print("> ");
    }
}

