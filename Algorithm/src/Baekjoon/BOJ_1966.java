package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int count = 0;

            Queue<int[]> queue = new LinkedList<>();
            for(int j = 0; j < N; j++)
                queue.offer(new int[] {j, sc.nextInt()});

            while(!queue.isEmpty()) {
                count++;
                int max = queue.peek()[1];

                for(int j = 0; j < queue.size(); j++) {
                    int[] poll = queue.poll();
                    if(max < poll[1]) max = poll[1];
                    queue.offer(poll);
                }

                while(queue.peek()[1] != max) {
                    queue.offer(queue.poll());
                }

                int[] delete = queue.poll();
                if(delete[0] == M)
                    sb.append(count).append('\n');
            }
        }

        System.out.println(sb);
    }
}
