package Baekjoon;

import java.util.Scanner;

public class BOJ_1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 어떤 수 N

        for(int i = N; i <= Integer.MAX_VALUE; i++) { // N ~ 1,000,000 까지 순환
            String normal = String.valueOf(i);
            StringBuffer sb = new StringBuffer(String.valueOf(i)); // i를 문자열로 변환
            String reverse = sb.reverse().toString(); // 뒤집은 수
            
            // 뒤집은 수가 일치 하지 않는경우 생략
            if(!normal.equals(reverse)) continue;

            // 소수가 아닌경우 생략
            if(!isPrime(Integer.parseInt(normal))) continue;

            System.out.println(i);
            return;
        }
    }

    public static boolean isPrime(int n) {
        if(n == 1)
            return false;

        if(n == 2)
            return true;

        if(n % 2 == 0)
            return false;

        for(int i = 3; i <= Math.sqrt(n); i+=2) {
            if(n % i == 0)
                return false;
        }

        return true;
    }
}
