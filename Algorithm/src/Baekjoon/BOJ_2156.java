package Baekjoon;

import java.util.Scanner;

public class BOJ_2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] amount = new int[n+1];
        int[] value = new int[n+1];
        int max = 0;

        for(int i = 1; i <= n; i++)
            amount[i] = sc.nextInt();

        if(n == 1) {
            System.out.println(amount[1]);
            return;
        } else if(n == 2) {
            System.out.println(amount[1] + amount[2]);
            return;
        }

        value[1] = amount[1];
        value[2] = amount[1] + amount[2];
        max = Math.max(max, value[2]);
        value[3] = Math.max(amount[1], amount[2]) + amount[3];
        max = Math.max(max, value[3]);

        for(int i = 4; i <= n; i++) {
            value[i] = Math.max(value[i-2] + amount[i],
                    Math.max(amount[i-1] + value[i-3] + amount[i],
                            amount[i-1] + value[i-4] + amount[i]));

            max = Math.max(max, value[i]);
        }

        System.out.println(max);
    }
}
