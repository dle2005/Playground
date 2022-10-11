package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] frame = new int[N];
        int[] likes = new int[101];
        int[] old = new int[101];
        int empty = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());

            if (likes[n] > 0) {
                // 현재 사진이 게시된 학생이 다른 학생의 추천을 받는 경우에는
                // 추천받은 횟수만 증가시킨다.
                likes[n]++;
            } else {
                if (empty < N) {
                    // 사진틀이 비어있는 경우 학생을 사진틀에 게시
                    frame[empty++] = n;
                    likes[n]++;
                    old[n] = i;
                } else {
                    // 비어있는 사진틀이 없는 경우
                    int min = Integer.MAX_VALUE, idx = -1;
                    for (int j = 0; j < N; j++) {
                        int f = frame[j];

                        if (likes[f] == min) {
                            // 가장 적은 학생이 두 명 이상일 경우 가장 오래된 사진을 삭제
                            if (old[f] < old[frame[idx]]) {
                                idx = j;
                            }
                        } else if (likes[f] < min) {
                            // 추천 받은 횟수가 가장 적은 학생의 사진을 삭제
                            min = likes[f];
                            idx = j;
                        }
                    }

                    likes[frame[idx]] = 0;
                    old[frame[idx]] = 0;

                    frame[idx] = n;
                    likes[n]++;
                    old[n] = i;
                }
            }
        }

        Arrays.sort(frame);

        StringBuilder sb = new StringBuilder();
        for (int n : frame) {
            if (n != 0) {
                sb.append(n).append(" ");
            }
        }

        System.out.println(sb);
    }
}
