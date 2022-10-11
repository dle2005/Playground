package Baekjoon;

import java.util.Scanner;

public class BOJ_1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] board = new char[n][m];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int min = 8 * 8;
        for(int i = 0; i < n - 7; i++) {
            for(int j = 0; j < m - 7; j++) {
                if(find_min(i, j, board) < min) min = find_min(i, j, board);
            }
        }

        System.out.println(min);

        sc.close();
    }

    public static int find_min(int x, int y, char[][] board) {
        int changes = 0;

        char color = board[x][y];
        for(int i = x; i < x + 8; i++) {
            for(int j = y; j < y + 8; j++) {
                if(board[i][j] != color) changes++;

                if(color == 'W') color = 'B';
                else color = 'W';
            }

            if(color == 'W') color = 'B';
            else color = 'W';
        }
        
        changes = Math.min(changes, 8 * 8 - changes);

        return changes;
    }
}
