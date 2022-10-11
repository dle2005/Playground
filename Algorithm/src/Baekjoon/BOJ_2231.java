package Baekjoon;

import java.util.Scanner;

public class BOJ_2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int min = n - (8 * String.valueOf(n).length());
        int result = 0;

        for(int i = min; i < n; i++) {
            int sum = i;
            int temp = i;

            while(true) {
                sum += temp % 10;
                temp /= 10;
                if(temp == 0) break;
            }

            if(sum == n) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
