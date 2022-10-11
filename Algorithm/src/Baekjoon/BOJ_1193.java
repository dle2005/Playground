package Baekjoon;

import java.util.Scanner;

public class BOJ_1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int a = 1, b = 1;
        boolean up = false;

        if(x != 1) b++;

        for(int i = 2; i < x; i++) {
            if(a == 1 && up) {
                b++;
                up = false;
            }
            else if(b == 1 && !up) {
                a++;
                up = true;
            }
            else if(up) {
                a--;
                b++;
            }
            else {
                a++;
                b--;
            }
        }

        System.out.println(a + "/" + b);

        sc.close();
    }
}
