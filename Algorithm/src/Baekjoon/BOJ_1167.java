package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class BOJ_1167 {
    public static boolean[] visit;
    public static List<int[]>[] list;
    public static int max, root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());
        list = new LinkedList[V+1];
        for(int i = 0; i <= V; i++)
            list[i] = new LinkedList<>();

        visit = new boolean[V+1];
        max = root = 0;

        for(int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            while(true) {
                int node = Integer.parseInt(st.nextToken());
                if(node == -1) break;
                int dist = Integer.parseInt(st.nextToken());

                int[] arr = {node, dist};
                list[v].add(arr);
            }
        }

        dfs(1, 0);

        visit = new boolean[V+1];
        dfs(root, 0);

        System.out.println(max);
    }

    public static void dfs(int node, int length) {
        ListIterator<int[]> iterator = list[node].listIterator();
        visit[node] = true;

        while(iterator.hasNext()) {
            int[] arr = iterator.next();

            if(!visit[arr[0]])
                dfs(arr[0], length + arr[1]);
        }

        if(max < length) {
            max = length;
            root = node;
        }
    }
}
