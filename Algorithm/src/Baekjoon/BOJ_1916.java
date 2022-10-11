package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1916 {
    public static class Node implements Comparable<Node> {
        int dest;
        int distance;

        public Node(int dest, int distance) {
            this.dest = dest;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //  도시의 개수
        int M = Integer.parseInt(br.readLine()); // 버스의 개수

        List<Node>[] list = new List[N+1]; // 인전리스트의 형태로 저장
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 출발점
            int dest = Integer.parseInt(st.nextToken()); // 도착점
            int distance = Integer.parseInt(st.nextToken()); // 거리

            list[start].add(new Node(dest, distance)); // 인접리스트에 저장
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 출발점의 도시번호
        int B = Integer.parseInt(st.nextToken()); // 도착점의 도시번호

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(A, 0)); // 출발지점부터 시작

        boolean[] visit = new boolean[N+1]; // 사이클 방지용
        int[] min = new int[N+1]; // A도시로부터 모든 정점으로의 최단거리
        Arrays.fill(min, Integer.MAX_VALUE); // 최단거리 INF 값으로 초기
        min[A] = 0; // 출발 도시에서 출발 도시는 0으로 초기화

        while(!queue.isEmpty()) {
            Node q = queue.poll();

            if(visit[q.dest]) continue; // 방문했으면 생략
            visit[q.dest] = true; // 방문했음으로 갱신

            // 새로 추가된 노드로부터 갈 수 있는 모든 정점으로 검사
            for(Node node : list[q.dest]) {
                // 기존 정점에서의 거리와 새로운 정점을 거쳐서 가는 것을 비교
                // 새로운 정점을 통해 갈 수 있다면 갱신
                // min[node.dest] = 기존 정점에서의 거리
                // min[q.dest] = 새로운 정점까지의 거리
                // node.distance = 새로운 정점에서 다른 노드와의 거리
                if(min[node.dest] > min[q.dest] + node.distance) {
                    min[node.dest] = min[q.dest] + node.distance;
                    // 새로운 길이 생겼음으로 큐에 추가
                    // 이때 거리는 현재 자신까지 오는데 걸린 거리로 추가
                    queue.offer(new Node(node.dest, min[node.dest]));
                }
            }
        }

        System.out.println(min[B]);
    }
}
