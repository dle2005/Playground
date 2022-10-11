package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2529 {
    public static boolean[] visit = new boolean[10];
    public static int n;
    public static List<String> list = new ArrayList<>();
    public static char[] sign;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        sign = new char[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++)
            sign[i] = st.nextToken().charAt(0);

        dfs("", 0);

        Collections.sort(list);

        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }

    public static void dfs(String s, int depth) {
        if(depth == n + 1) {
            list.add(s);
            return;
        }

        for(int i = 0; i < 10; i++) {
            if(!visit[i]) {
                if(depth == 0 || isPromise(depth, s.charAt(depth-1)-48, i)) {
                    visit[i] = true;
                    dfs(s + i, depth + 1);
                    visit[i] = false;
                }
            }
        }
    }

    public static boolean isPromise(int depth, int a, int b) {
        if(sign[depth-1] == '<') {
            if (a > b) return false;
        }
        else if(sign[depth-1] == '>') {
            if (a < b) return false;
        }

        return true;
    }
}
