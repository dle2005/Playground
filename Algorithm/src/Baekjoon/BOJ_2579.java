package Baekjoon;

import java.util.Scanner;

public class BOJ_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] cost = new int[n+1];
        int[] value = new int[n+1];

        for(int i = 1; i <=n; i++)
            cost[i] = sc.nextInt();

        if(n == 1) {
            System.out.println(cost[1]);
            return;
        }

        value[1] = cost[1];
        value[2] = cost[1] + cost[2];
        for(int i = 3; i <=n; i++) {
            value[i] = Math.max(value[i-2] + cost[i],
                    cost[i-1] + value[i-3] + cost[i]);
        }

        System.out.println(value[n]);
    }
}
