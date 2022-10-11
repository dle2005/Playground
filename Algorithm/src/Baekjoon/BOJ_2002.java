package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 들어오는 차량 번호와 순서를 저장
        Map<String, Integer> in = new HashMap<>();
        for(int i = 0; i < N; i++)
            in.put(br.readLine(), i);

        // 나가는 차량의 순서를 저장
        int[] out = new int[N];

        // 나가는 차량 순서를 Map 에서 Key 값으로 탐색해서 가져옴
        for(int i = 0; i < N; i++) {
            String car_number = br.readLine();
            out[i] = in.get(car_number);
        }

        // 자신보다 뒤에 먼저 들어간 차량이 있는 경우 추월한 것임
        int wrong_order = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i+1; j < N; j++) {
                if(out[i] > out[j]) {
                    wrong_order++;
                    break;
                }
            }
        }

        System.out.println(wrong_order);
    }
}
