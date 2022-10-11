package Baekjoon;

import java.util.Scanner;

public class BOJ_10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[][] arr = new long[N+1][10];

        for(int i = 1; i <= 9; i++)
            arr[1][i] = 1;

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j <= 9; j++) {
                if(j == 0)
                    arr[i][j] = arr[i-1][1] % 1000000000;
                else if(j == 9)
                    arr[i][j] = arr[i-1][8] % 1000000000;
                else
                    arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1]) % 1000000000;
            }
        }

        long result = 0;
        for(long i : arr[N])
            result+= i;

        System.out.println(result % 1000000000);
    }
}
