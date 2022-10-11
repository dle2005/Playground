package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1091 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 카드의 수

        int[] P = new int[N]; // 플레이어
        int[] origin = Arrays.copyOf(P, N);
        int[] temp = new int[N];
        int[] answer = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            answer[i] = i % 3;
        }

        int[] S = new int[N]; // 섞는 방법
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) S[i] = Integer.parseInt(st.nextToken());

        int cnt = 0; // 섞는 횟수
        while (true) { // 카드 섞기
            boolean flag = true;

            if(Arrays.equals(P, answer)) {
                System.out.println(cnt);
                return;
            }

            temp = Arrays.copyOf(P, N); // 교환을 편하게 하기 위한 배열
            for(int i = 0; i < N; i++)
                P[S[i]] = temp[i];

            if(Arrays.equals(P, origin) || cnt > 120119) {
                System.out.println(-1);
                return;
            }

            cnt++;
        }
    }
}
