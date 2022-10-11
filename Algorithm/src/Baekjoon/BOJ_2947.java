package Baekjoon;

import java.util.Scanner;

public class BOJ_2947 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        int[] answer = new int[6];

        for(int i = 1; i <= 5; i++) {
            arr[i] = sc.nextInt();
            answer[i] = i;
        }

        int from = 1, to = 2;

        while(!equals(arr, answer)) {
            if(arr[from] > arr[to]) {
                int temp = arr[from];
                arr[from] = arr[to];
                arr[to] = temp;

                for(int i = 1; i <=5; i++)
                    System.out.print(arr[i] + " ");
                System.out.println();
            }

            from++; to++;

            if(from == 5) {
                from = 1; to = 2;
            }
        }
    }

    public static boolean equals(int[] o1, int[] o2) {
        for(int i = 1; i <= 5; i++) {
            if(o1[i] != o2[i])
                return false;
        }

        return true;
    }
}
