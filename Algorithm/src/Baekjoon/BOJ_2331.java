package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2331 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int A = sc.nextInt();
        int P = sc.nextInt();

        while (true) {
            if(list.contains(A)) {
                System.out.println(list.indexOf(A));
                break;
            }
            else {
                list.add(A);
            }

            int temp = A, sum = 0;

            while(temp != 0) {
                sum += (int) Math.pow(temp % 10, P);
                temp /= 10;
            }

            A = sum;
        }
    }
}
