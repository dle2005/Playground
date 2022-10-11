package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1753 {
    static class Node implements Comparable<Node>{
        int dest;
        int weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수

        int K = Integer.parseInt(br.readLine()); // 시작 정점의 번호

        List<Node>[] list = new List[V+1]; // 인접리스트 배열
        for(int i = 0; i <= V; i++)
            list[i] = new ArrayList<>();

        int[] min = new int[V+1]; // 최소값 저장할 배열
        Arrays.fill(min, Integer.MAX_VALUE); // INF로 초기화
        min[K] = 0;

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken()); // 출발 정점
            int v = Integer.parseInt(st.nextToken()); // 도착 정점
            int w = Integer.parseInt(st.nextToken()); // 가중치

            list[u].add(new Node(v, w)); // 연결리스트로 저장
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visit = new boolean[V+1]; // 사이클 방지
        q.add(new Node(K, 0));

        while (!q.isEmpty()) {
            Node temp = q.poll();
            int v = temp.dest;

            if(visit[v]) continue; // 이미 방문한 노드인 경우 스킵
            visit[v] = true;

            for(Node t : list[v]) { // 탐색할 노드에서 출발하는 모든 간선 검사
                if(min[t.dest] > min[v] + t.weight) { // 새로운 노드를 거쳐서
                    min[t.dest] = min[v] + t.weight; // 가는 방법이 더 빠르다면 갱신
                    q.offer(new Node(t.dest, min[t.dest])); // 큐에 노드를 추가
                } // 이때, 가중치는 현재 자신까지 오는데 걸린 가중치로 추가
            }

        }

        for(int i = 1; i <= V; i++) {
            if(min[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(min[i]);
        }

    }
}
