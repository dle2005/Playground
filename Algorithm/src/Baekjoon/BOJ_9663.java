package Baekjoon;

import java.util.Scanner;

public class BOJ_9663 {
    public static int N, count = 0;
    public static int[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        visit = new int[N];

        n_queens(0);
        System.out.println(count);
    }

    public static void n_queens(int depth) {
        if(depth == N) {
            count++;
            return;
        }

        for(int i = 0; i < N; i++) {
            visit[depth] = i;

            if(isPromise(depth))
                n_queens(depth+1);
        }
    }

    public static boolean isPromise(int depth) {
        for(int i = 0; i < depth; i++) {
            if(visit[depth] == visit[i])
                return false;

            if(Math.abs(depth - i) == Math.abs(visit[depth] - visit[i]))
                return false;
        }

        return true;
    }

}
