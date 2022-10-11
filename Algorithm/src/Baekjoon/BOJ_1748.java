package Baekjoon;

import java.util.Scanner;

public class BOJ_1748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int length = s.length();

        if(length == 1) {
            System.out.println(Integer.parseInt(s));
            return;
        }

        int result = 0;
        for(int i = 0; i < length-1; i++)
            result += 9 * (i+1) * Math.pow(10, i);

        int n = Integer.parseInt(s);
        int rest = n - (int)Math.pow(10, length-1);
        result += (rest+1) * length;

        System.out.println(result);



    }
}
