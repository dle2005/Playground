package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1092 {
    public static void main(String[] args) throws IOException {
        // 크레인이 N대 있고, 1분에 박스를 하나씩 배에 실을 수 있다.
        // 모든 크레인은 동시에 움직인다.

        // 각 크레인은 무게 제한이 있다. 이 무게 제한보다 무거운 박스는 크레인으로 움직일 수 없다.
        // 모든 박스를 배로 옮기는데 드는 시간의 최솟값을 구하는 프로그램

        // 만약 모든 박스를 배로 옮길 수 없으면 -1을 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 크레인의 수, N <= 50

        List<Integer> max_weight = new ArrayList<>(); // 각 크레인의 무게 제한
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++)
            max_weight.add(Integer.parseInt(st.nextToken()));

        // 크레인의 무게 제한을 정렬 -> 역순이 편하지만 역순으로 만들기 번거로움
        Collections.sort(max_weight, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int M = Integer.parseInt(br.readLine()); // 박스의 수, M <= 10,000

        List<Integer> box_weight = new ArrayList<>(); // 각 박스의 무게
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++)
            box_weight.add(Integer.parseInt(st.nextToken()));

        // 박스의 무게를 역순으로 정렬
        Collections.sort(box_weight, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 모든 박스를 배로 옮길 수 없는 경우
        if(max_weight.get(0) < box_weight.get(0)) {
            System.out.println(-1);
            return;
        }

        // 시간
        int time = 0;
        while(!box_weight.isEmpty()) {
            int idx = 0;
            int tmp = 0;

            while(idx < N) {
                if(tmp == box_weight.size())
                    break;
                if(box_weight.get(tmp) <= max_weight.get(idx)) {
                    box_weight.remove(tmp);
                    idx++;
                }
                else if(box_weight.get(tmp) > max_weight.get(idx))
                    tmp++;
            }

            time++;
//
//            // 모든 크레인이 동작
//            for(int crain : max_weight) {
//                // 박스를 다 옮긴 경우 출력 후 종료
//                if(box_weight.isEmpty()) break;
//
//                for(int k = 0; k < box_weight.size(); k++) {
//                    if(!box_weight.isEmpty() && crain >= box_weight.get(k)) {
//                        box_weight.remove(k);
//                        break;
//                    }
//                }
            }
        System.out.println(time);

    }
}
