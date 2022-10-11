package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1781 {
    public static class HomeWork implements Comparable<HomeWork> {
        int deadLine;
        int cup;

        public HomeWork(int deadLine, int cup) {
            this.deadLine = deadLine;
            this.cup = cup;
        }

        @Override
        public int compareTo(HomeWork o) {
            return this.deadLine - o.deadLine;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HomeWork[] homeWork = new HomeWork[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int cup = Integer.parseInt(st.nextToken());

            homeWork[i] = new HomeWork(deadline, cup);
        }

        Arrays.sort(homeWork);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(homeWork[i].cup);

            while (homeWork[i].deadLine < pq.size())
                pq.poll();
        }

        int answer = 0;

        while (!pq.isEmpty()) answer += pq.poll();

        System.out.println(answer);
    }
}
