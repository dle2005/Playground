package Baekjoon;

import java.util.Scanner;

public class BOJ_2877 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        String binary = Integer.toBinaryString(K+1); // K+1을 2진수로 변환
        binary = binary.substring(1); // 첫번째 자리를 제외

        // 범위가 최대 10^9 이므로 BigInteger 혹은 String 사용
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < binary.length(); i++) { // 2진수의 각 자리 검사
            if(binary.charAt(i) == '0')
                sb.append('4'); // 0인경우 4를 추가 
            else
                sb.append('7'); // 1인 경우 7을 추가 
        }

        System.out.println(sb);

        // K를 이진수로 바꿔 생각해보면 K+1의 첫번째 자리를 뺀것이 K가 됨
        // 4 = 0, 7 = 1로 표현

        // 1 -> 4 <-> 1 -> 0
        // 2 -> 7 <-> 10 -> 1

        // 3 -> 44 <-> 11 -> 00
        // 4 -> 47 <-> 100 -> 01
        // 5 -> 74 <-> 101 -> 10
        // 6 -> 77 <-> 110 -> 11

        // 7 -> 444 <-> 111-> 000
        // 8 -> 447 <-> 1000 -> 001
        // 9 -> 474 <-> 1001 -> 010
        // 10 -> 477 <-> 1010 -> 011
        // 11 -> 744 <-> 1011 -> 100
        // 12 -> 747 <-> 1100 -> 101
        // 13 -> 774 <-> 1101 -> 110
        // 14 -> 777 <-> 1110 -> 111
    }
}
