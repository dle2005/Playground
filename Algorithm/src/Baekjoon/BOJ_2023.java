package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2023 {
    public static int[] arr = {1, 2, 3, 5, 7};
    public static int N;
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();


        backTracking(0,0);

        for(int i : list)
            System.out.println(i);

    }

    public static void backTracking(int n, int depth) {
        if(depth == N) {
            list.add(n);
            return;
        }

        n = n*10;

        if(depth == 0) {
            for(int i = 1; i < arr.length; i++)
                backTracking(n+arr[i], depth+1);
        }
        else {
            for(int i = 1; i <= 9; i++) {
                if(!isPrime(n + i))
                    backTracking(n + i, depth+1);
            }
        }
    }

    public static boolean isPrime(int n) {
        boolean tf = false;

        for(int i = 2; i < n; i++) {
            if(n % i == 0) {
                tf = true;
                break;
            }
        }

        return tf;
    }
}
