package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Rod> list = new ArrayList<>();
        int highest = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            list.add(new Rod(l, h));

            // 가장 큰 기둥 기준으로 좌에서 우로, 우에서 좌로 계산
            highest = Math.max(highest, h);
        }

        Collections.sort(list); // 위치를 기준으로 정렬

        int answer = 0;

        Rod cur = list.get(0); // 현재 가장 높은 기둥
        int idx = 1; // 비교할 기둥의 index

        for (; idx < list.size(); idx++) { // 좌에서 우로
            if (cur.h <= list.get(idx).h) { // 더 큰 기둥 발견시
                answer += cur.h * (list.get(idx).l - cur.l); // 영역 추가
                cur = list.get(idx);
            }

            if (list.get(idx).h == highest) { // 가장 큰 기둥 발견 시 종료
                break;
            }
        }
        answer += highest;// 가장 큰 기둥의 크기 추가

        cur = list.get(list.size() - 1);
        for (int i = list.size() - 2; i >= idx; i--) { // 우에서 좌로
            if (cur.h <= list.get(i).h) {
                answer += cur.h * (cur.l - list.get(i).l);
                cur = list.get(i);
            }
        }

        System.out.println(answer);
    }

    public static class Rod implements Comparable<Rod> {
        int l, h;

        public Rod(int l, int h) {
            this.l = l;
            this.h = h;
        }

        @Override
        public int compareTo(Rod o) {
            return this.l - o.l;
        }
    }
}
