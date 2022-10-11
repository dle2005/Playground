package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 장애물의 수
        int H = Integer.parseInt(st.nextToken()); // 구간의 수 & 장애물 최대 크기

        int[] topDown = new int[H+1]; // 석순
        int[] bottomUp = new int[H+1]; // 종유석

        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if(i % 2 == 0)
                bottomUp[n]++; // n길이 증가
            else
                topDown[n]++;
        }

        for(int i = H-2; i > 0; i--) {
            topDown[i] += topDown[i+1];
            bottomUp[i] += bottomUp[i+1];
        }

        int[] level = new int[H+1];

        level[1] = topDown[1];
        level[H] = bottomUp[1];
        for(int i = 2; i < H; i++)
            level[i] = topDown[i] + bottomUp[H-i+1];

        Arrays.sort(level);

        int count = 0, min = level[1];
        for(int i = 1; i <= H; i++) {
            if(min == level[i])
                count++;
            else {
                System.out.println(min + " " + count);
                break;
            }
        }
    }
}
