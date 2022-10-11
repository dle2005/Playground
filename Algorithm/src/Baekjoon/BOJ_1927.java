package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) {
                if(priorityQueue.isEmpty())
                    sb.append(0).append("\n");
                else
                    sb.append(priorityQueue.poll()).append("\n");
            }
            else
                priorityQueue.add(n);
        }

        System.out.println(sb);
    }
}
