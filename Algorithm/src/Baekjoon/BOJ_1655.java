package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        while (N-- > 0) {
            int n = Integer.parseInt(br.readLine());

            if (maxQueue.size() == minQueue.size()) maxQueue.offer(n);
            else minQueue.offer(n);

            if (!maxQueue.isEmpty() && !minQueue.isEmpty()) {
                if (maxQueue.peek() > minQueue.peek()) {
                    int temp = maxQueue.poll();
                    maxQueue.offer(minQueue.poll());
                    minQueue.offer(temp);
                }
            }

            sb.append(maxQueue.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
