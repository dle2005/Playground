package Baekjoon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deque = new LinkedList<>();

        int N = sc.nextInt();
        for(int i = 1; i <= N; i++)
            deque.offer(i);

        while(deque.size() != 1) {
            deque.poll();

            deque.offerLast(deque.poll());
        }

        System.out.println(deque.peek());
    }
}
