package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1068 {
    public static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        list = new List[N];
        for(int i = 0; i < N; i++)
            list[i] = new ArrayList<>();
        int[] parent = new int[N];

        int root = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            if(n == -1) root = i;
            else {
                list[n].add(i);
                parent[i] = n;
            }
        }

        int d = Integer.parseInt(br.readLine());

        if (d == root) {
            System.out.println(0);
            return;
        }

        list[parent[d]].remove((Object)d);

        dfs(root);

        System.out.println(answer);
    }

    public static int answer;

    public static void dfs(int n) {
        if(list[n].size() == 0){
            answer++;
            return;
        }

        for(int i : list[n])
            dfs(i);
    }
}
