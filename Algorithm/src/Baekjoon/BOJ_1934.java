package Baekjoon;

import java.util.Scanner;

public class BOJ_1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int val1 = a, val2 = b;
            if(val1 < val2) {
                val1 = b;
                val2 = a;

                a = val1;
                b = val2;
            }
            
            int r = 1;
            while(r > 0) {
                r = val1 % val2;
                val1 = val2;
                val2 = r;
            }

            System.out.println(a*b/val1);
        }
    }
}
