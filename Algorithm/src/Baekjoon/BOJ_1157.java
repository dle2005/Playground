package Baekjoon;

import java.util.Scanner;

public class BOJ_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        input = input.toUpperCase();
        int[] alp = new int[26];
        int max = 0;
        char result = '?';

        for(int i = 0; i < input.length(); i++) {
            alp[input.charAt(i) - 65]++;

            if(max < alp[input.charAt(i) - 65]) {
                max = alp[input.charAt(i) - 65];
                result = input.charAt(i);
            }
            else if(max == alp[input.charAt(i) - 65])
                result = '?';
        }

        System.out.println(result);
        
        sc.close();
    }
}
