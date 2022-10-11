package Baekjoon;

import java.util.Scanner;

public class BOJ_1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            if(d == 0 && r1 == r2) System.out.println(-1);
            else if(d == 0 && r1 != r2) System.out.println(0);
            else if(d > r1 + r2) System.out.println(0);
            else if(d < Math.abs(r2 - r1)) System.out.println(0);
            else if(d == Math.abs(r2 - r1)) System.out.println(1);
            else if(d == r1 + r2) System.out.println(1);
            else System.out.println(2);
        }

        sc.close();
    }
}
