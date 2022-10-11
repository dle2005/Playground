package Baekjoon;

import java.util.Scanner;

public class BOJ_2578 {
    public static int[][] bingo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        bingo = new int[5][5];

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++)
                bingo[i][j] = sc.nextInt();
        }

        for(int i = 1; i <= 25; i++) {
            int n = sc.nextInt();
            int num = numBingo(n);

            if(num >= 3) {
                System.out.println(i);
                break;
            }
        }
    }

    public static int numBingo(int n) {
        int[] h = new int[5]; // 세로 줄 검사
        int lr = 0;
        int rl = 0;

        int total = 0;

        for(int i = 0; i < 5; i++) {
            int v = 0; // 가로 줄 검사

            for(int j = 0; j < 5; j++) {
                if(bingo[i][j] == n)
                    bingo[i][j] = 0;

                if(bingo[i][j] == 0) {
                    v++;
                    h[j]++;
                }

                if(bingo[i][j] == 0 && i == j)
                    lr++;

                if(bingo[i][j] == 0 && j == 4-i)
                    rl++;
            }

            if(v == 5)
                total++;
        }

        for(int i : h) {
            if (i == 5) total++;
        }

        if(lr == 5) total++;
        if(rl == 5) total++;

//        System.out.println();
//        for(int[] i : bingo) {
//            for (int j : i)
//                System.out.print(j + " ");
//            System.out.println();
//        }

        return total;
    }
}
