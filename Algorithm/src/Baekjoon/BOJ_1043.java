package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1043 {
    public static int[] parent;
    public static int[][] party;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            int p = Integer.parseInt(st.nextToken());
            parent[p] = p;
        }

        party = new int[M][];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            party[i] = new int[Integer.parseInt(st.nextToken())];

            for (int j = 0; j < party[i].length; j++)
                party[i][j] = Integer.parseInt(st.nextToken());

            if (party[i].length >= 2) {
                for (int j = 1; j < party[i].length; j++)
                    union(party[i][0], party[i][j]);
            }
        }
        
        int cnt = 0;

        for (int i = 0; i < M; i++) {
            if (isValid(i)) cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean isValid(int i) {
        for (int j = 0; j < party[i].length; j++) {
            int temp = find(party[i][j]);
            if (parent[temp] == temp) return false;
        }
        return true;
    }

    public static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if (aParent != bParent) {
            if (aParent == parent[aParent]) parent[bParent] = aParent;
            else parent[aParent] = bParent;
        }
    }

    public static int find(int a) {
        if (parent[a] == 0 || parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
}
