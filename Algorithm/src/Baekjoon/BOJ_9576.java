package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            App[] apps = new App[M];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;

                apps[i] = new App(a, b);
            }

            Arrays.sort(apps);
            boolean[] visit = new boolean[N];

            int answer = 0;
            for (int i = 0; i < M; i++) {
                int a = apps[i].a;
                int b = apps[i].b;

                for (int j = a; j <= b; j++) {
                    if (!visit[j]) {
                        visit[j] = true;
                        answer++;
                        break;
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public static class App implements Comparable<App> {
        int a;
        int b;

        public App(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(App o) {
            if (this.b == o.b) {
                return this.a - o.a;
            } else {
                return this.b - o.b;
            }
        }
    }
}
