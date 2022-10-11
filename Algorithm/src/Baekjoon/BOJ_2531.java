package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int answer, cur = 0;

        int[] exist = new int[d + 1];
        for (int i = 0; i < k; i++) {
            if (exist[belt[i]]++ == 0) {
                cur++;
            }
        }
        answer = cur;

        for (int i = 1; i < N; i++) {
            if (answer <= cur) {
                answer = exist[c] == 0 ? cur + 1 : cur;
            }

            if (--exist[belt[i - 1]] == 0) {
                cur--;
            }

            if (exist[belt[(i + k - 1) % N]]++ == 0) {
                cur++;
            }
        }

        System.out.println(answer);
    }
}
