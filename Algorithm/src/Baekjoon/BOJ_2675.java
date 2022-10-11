package Baekjoon;

import java.util.Scanner;

public class BOJ_2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int r = 0;
        String p = "", result = "";

        for(int i = 0; i < t; i++) {
            r = sc.nextInt();
            p = sc.next();
            result = "";
            
            for(int j = 0; j < p.length(); j++)
                for(int k = 0; k < r; k++)
                    result += p.charAt(j);

            System.out.println(result);
        }

        sc.close();
    }
}
