package Baekjoon;

import java.util.Scanner;

public class BOJ_5622 {
    private static int cDial(char c) {
        switch (c) {
            case 'A' : case 'B' : case 'C' :
                return 3;
            case 'D' : case 'E' : case 'F' :
                return 4;
            case 'G' : case 'H' : case 'I' :
                return 5;
            case 'J' : case 'K' : case 'L' :
                return 6;
            case 'M' : case 'N' : case 'O' :
                return 7;
            case 'P' : case 'Q' : case 'R' : case 'S' :
                return 8;
            case 'T' : case 'U' : case 'V' :
                return 9;
            case 'W' : case 'X' : case 'Y' : case 'Z' :
                return 10;
            default: return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        int result = 0;

        for(int i = 0; i < input.length(); i++)
            result += cDial(input.charAt(i));
        
        System.out.println(result);

        sc.close();
    }
}
