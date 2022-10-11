package Baekjoon;

import java.util.Scanner;

public class BOJ_2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        String[] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        int count = 0;

        for(int i = 0; i < cro.length; i++)
            input = input.replaceAll(cro[i], "*");

        System.out.println(input.length());

        sc.close();
    }
}
