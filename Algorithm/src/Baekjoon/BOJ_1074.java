package Baekjoon;

import java.util.Scanner;

public class BOJ_1074 {
    public static int r, c, count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        divide(0, 0, (int)Math.pow(2, N));
    }

    public static void divide(int i, int j, int N) {
        if(N == 2) {
            if(r < i+2 && c < j+2)
                visit(i, j);
            else
                count += 4;
        }
        else {
            if(i <= r && r < i + N/2 && j <= c && c < j+N/2)
                divide(i, j, N/2);
            else
                count += N/2 * N/2;

            if(i <= r && r < i + N/2 && j+N/2 <= c && c < j+N)
                divide(i, j+N/2, N/2);
            else
                count += N/2 * N/2;

            if(i+N/2 <= r && r < i + N && j <= c && c < j+N/2)
                divide(i+N/2, j, N/2);
            else
                count += N/2 * N/2;

            if(i+N/2 <= r && r < i + N && j+N/2 <= c && c < j+N)
                divide(i+N/2, j+N/2, N/2);
            else
                count += N/2 * N/2;
        }
    }

    public static void visit(int y, int x) {
        for(int i = y; i < y + 2; i++) {
            for(int j = x; j < x + 2; j++) {
                if(i == r && j == c) {
                    System.out.println(count);
                    System.exit(0);
                }

                count++;
            }
        }
    }
}
