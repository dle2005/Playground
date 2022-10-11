package Baekjoon;

import java.util.Scanner;

public class BOJ_1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int k = sc.nextInt();

        long low = 1, high = k;
        long answer = 0;
        while(low <= high) {
            long mid = (low + high) / 2;
            int below = 0;

            for(int i = 1; i <= N; i++)
                below += Math.min(mid / i, N);
            
            if(below < k)
                low = mid + 1;
            else {
                answer = mid;
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
