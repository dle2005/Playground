package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603 {
    public static int[] arr;
    public static int n;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;
            arr = new int[n];
            visit = new boolean[n];

            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            dfs(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int begin, int depth) {
        if(depth == 6) {
            for(int i = 0; i < n; i++)
                if(visit[i])
                    sb.append(arr[i]).append(" ");
            sb.append("\n");
        }

        for(int i = begin; i < n; i++) {
            visit[i] = true;
            dfs(i+1, depth+1);
            visit[i] = false;
        }
    }
}
