package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202 {
    public static class Jewelry implements Comparable<Jewelry> {
        int weight;
        int cost;

        public Jewelry(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }

        @Override
        public int compareTo(Jewelry o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewelry[] j_arr = new Jewelry[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            j_arr[i] = new Jewelry(weight, cost);
        }
        Arrays.sort(j_arr);

        int[] c_arr = new int[K];
        for(int i = 0; i < K; i++)
            c_arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(c_arr);

        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int index = 0;
        for (int i = 0; i < K; i++) {
            for (int j = index; j < N; j++, index++) {
                if(j_arr[j].weight > c_arr[i]) break;

                queue.offer(j_arr[j].cost);
            }

            if(!queue.isEmpty()) answer += queue.poll();
        }

        System.out.println(answer);
    }
}
