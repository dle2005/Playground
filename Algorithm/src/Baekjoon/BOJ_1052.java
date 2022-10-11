package Baekjoon;

import java.util.Scanner;

public class BOJ_1052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int result = 0;

        if(N <= K) {
            System.out.println(0);
            return;
        }
        
        while(true) {
            int T = N;
            int count = 0;

            while(T != 0) {
                if(T % 2 == 1)
                    count++;

                T /= 2;
            }


            if(count <= K)
                break;
            
            result++;
            N++;
        }

        System.out.println(result);
    }
}
