package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1707 {
    public static List<Integer>[] list;
    public static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken()); // 정점의 개수
            int E = Integer.parseInt(st.nextToken()); // 간선의 개수

            list = new List[V+1];
            for(int j = 0; j <= V; j++)
                list[j] = new ArrayList<>();

            for(int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            // 각 정점을 방문할때 그룹핑을 해준다
            // 0 -> 방문 안함, 1 -> 1번째 그룹, 2 -> 2번째 그룹
            visit = new int[V+1];

            // 방문하지 않은 정점들에서 dfs 탐색 -> 그룹을 번갈아 가면서 넣음
            for(int j = 1; j <= V; j++) {
                if(visit[j] == 0) {
                    dfs(j, 1);
                }
            }

            boolean flag = true;

            // 자기자신과 자기자신 다음 노드가 같은 그룹이면 이분 그래프가 아님
            for(int j = 1; j <= V; j++) {
                for(int n : list[j]) {
                    if(visit[j] == visit[n]) {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }


    }

    public static void dfs(int i, int group) {
        visit[i] = group;

        // 3 - group 을 함으로써 번갈아 가면서 1, 2가 들어감
        for(int n : list[i]) {
            if(visit[n] == 0)
                dfs(n, 3 - group);
        }
    }
}
