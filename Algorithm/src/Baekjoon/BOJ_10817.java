package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10817 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = new int[3];
        
        for(int i = 0; i < 3; i++)
            input[i] = sc.nextInt();
        
        Arrays.sort(input);

        System.out.println(input[1]);

        sc.close();
    }
}
