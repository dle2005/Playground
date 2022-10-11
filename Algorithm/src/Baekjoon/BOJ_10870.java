package Baekjoon;

import java.util.Scanner;

public class BOJ_10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = 0;
        
        if(n == 0) result = 0;
        else result = fibonacci(n);

        System.out.println(result);

        sc.close();
    }
    public static int fibonacci(int n) {
        if(n == 1 || n == 2) return 1;
        else return fibonacci(n - 1) + fibonacci(n -2);
    }
}
