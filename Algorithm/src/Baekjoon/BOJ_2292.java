package Baekjoon;

import java.util.Scanner;

public class BOJ_2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int temp = 1, count = 2;
        
        if(n == 1) {
            System.out.println(1);
            return;
        }
        
        while(true) {
            if(n - temp <= 6 * (count - 1)) {
                System.out.println(count);
                break;
            }
            temp += (count - 1) * 6;
            count++;
        }

        sc.close();
    }
}
