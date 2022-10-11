package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2580 {
    public static int[][] arr = new int[10][10];
    public static List<int []> list = new ArrayList<>();
    public static Set<Integer> h_list;
    public static Set<Integer> v_list;
    public static Set<Integer> n_list;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <=9; j++) {
                int n = Integer.parseInt(st.nextToken());

                arr[i][j] = n;
                if(n == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }

        sudoku(0);
    }

    public static void sudoku(int start) {
        if(start == list.size()) {
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++)
                    sb.append(arr[i][j]).append(" ");
                sb.append("\n");
            }

            System.out.println(sb);
            System.exit(0);
        }

        int[] zero = list.get(start);
        for(int i = 1; i <= 9; i++) {
            if(isPromising(zero[0], zero[1], i)) {
                arr[zero[0]][zero[1]] = i;
                sudoku(start+1);
                arr[zero[0]][zero[1]] = 0;
            }
        }

    }

    public static boolean isPromising(int y, int x, int num) {
        for(int i = 1; i <= 9; i++) {
            if(arr[y][i] == num)
                return false;
        }

        for(int i = 1; i <= 9; i++) {
            if(arr[i][x] == num)
                return false;
        }

        y = (y - 1) / 3 * 3;
        x = (x - 1) / 3 * 3;

        for(int i = y+1; i <= y + 3; i++) {
            for(int j = x+1; j <= x + 3; j++) {
                if(arr[i][j] == num)
                    return false;
            }
        }

        return true;
    }
}
