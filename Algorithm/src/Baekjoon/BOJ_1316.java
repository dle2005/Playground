package Baekjoon;

import java.util.Scanner;

public class BOJ_1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String input = "";
        int result = n;

        for(int i = 0; i < n; i++) {
            input = sc.next();
            boolean[] alp = new boolean[26];

            for(int j = 1; j < input.length(); j++) {
                if(alp[input.charAt(j) - 97] == true) {
                    result--;
                    break;
                }
                if(input.charAt(j) != input.charAt(j-1))
                    alp[input.charAt(j - 1) - 97] = true;
            }
        }

        System.out.println(result);
        
        sc.close();
    }
}
