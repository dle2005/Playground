package Baekjoon;

import java.util.Scanner;

public class BOJ_2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int t1 = a;
        int t2 = b;
        if(a < b) {
            a = t2;
            b = t1;
        }

        int r = 1;
        while (r > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        
        System.out.println(a);
        System.out.println(t1*t2/a);
    }
}
