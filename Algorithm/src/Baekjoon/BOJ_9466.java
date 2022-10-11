package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466 {
    public static int[] students;
    public static boolean[] visit;
    public static boolean[] search;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            students = new int[n + 1];
            visit = new boolean[n + 1];
            search = new boolean[n + 1];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= n; i++)
                students[i] = Integer.parseInt(st.nextToken());

            cnt = 0;
            for (int i = 1; i <= n; i++) {
                if(!visit[i]) dfs(i);
            }

            System.out.println(n - cnt);
        }
    }

    public static void dfs(int cur) {
        visit[cur] = true;

        int next = students[cur];

        if (!visit[next]) dfs(next);
        else if(!search[next]){
            cnt++;
            while (next != cur) {
                cnt++;
                next = students[next];
            }
        }

        search[cur] = true;
    }
}
