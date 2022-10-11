package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Country> pq = new PriorityQueue<>(new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                if (o1.gold == o2.gold) {
                    if (o1.sliver == o2.sliver) {
                        if (o1.bronze == o2.bronze) {
                            if (o1.num == K) {
                                return -1;
                            } else if (o2.num == K) {
                                return 1;
                            }
                        }
                        return o2.bronze - o1.bronze;
                    }
                    return o2.sliver - o1.sliver;
                }
                return o2.gold - o1.gold;
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Country(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        int size = pq.size();
        for (int i = 0; i < size; i++) {
            if (pq.poll().num == K) {
                System.out.println(i + 1);
            }
        }
    }

    public static class Country {
        int num, gold, sliver, bronze;

        public Country(int num, int gold, int sliver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.sliver = sliver;
            this.bronze = bronze;
        }
    }
}
