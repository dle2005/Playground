package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        String[] numbers = new String[N];
        int[] strikes = new int[N];
        int[] balls = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            numbers[i] = st.nextToken();
            strikes[i] = Integer.parseInt(st.nextToken());
            balls[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        int[] index = new int[10];
        for (int i = 1; i <= 9; i++) {
            index[i] = 1;

            for (int j = 1; j <=9; j++) {
                if (i == j) continue;

                index[j] = 2;

                for (int k = 1; k <= 9; k++) {
                    if (j == k || i == k) continue;

                    index[k] = 3;

                    boolean flag = true;

                    for (int n = 0; n < N; n++) {
                        int strike = 0, ball = 0;

                        for (int c = 1; c <= 3; c++) {
                            int idx = index[numbers[n].charAt(c - 1) - '0'];

                            if (idx == c) {
                                strike++;
                            } else if (idx != 0) {
                                ball++;
                            }
                        }

                        if (strike != strikes[n] || ball != balls[n]) {
                            flag = false;

                            break;
                        }
                    }

                    if (flag) answer++;

                    index[k] = 0;
                }
                index[j] = 0;
            }
            index[i] = 0;
        }

        System.out.println(answer);
    }
}
