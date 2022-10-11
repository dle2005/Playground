package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] volume = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] answer = new boolean[volume[2] + 1]; // A가 비어 있을 때, C 물의 양
        answer[volume[2]] = true;

        // C -> A, C -> B, B -> A, B -> C, A -> B, A -> C
        int[] from = {0, 0, 1, 1, 2, 2};
        int[] to = {1, 2, 0, 2, 0, 1};

        Queue<Bucket> queue = new LinkedList<>();
        // A, B 물의 값 방문 여부
        boolean[][] visit = new boolean[volume[0] + 1][volume[1] + 1];

        queue.add(new Bucket(0, 0)); // 처음 A, B는 비어 있음
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Bucket cur = queue.poll();
            int A = cur.A, B = cur.B;
            int C = volume[2] - A - B;

            for (int k = 0; k < 6; k++) {
                int[] next = {A, B, C}; // 옮긴 뒤의 용량

                next[to[k]] += next[from[k]]; // 물 옮기기
                next[from[k]] = 0;

                if (next[to[k]] > volume[to[k]]) { // 용량 초과시
                    // 옮겨 온 곳으로 초과한 만큼 넣어준다
                    next[from[k]] = next[to[k]] - volume[to[k]];
                    next[to[k]] = volume[to[k]];
                }

                if (!visit[next[0]][next[1]]) {
                    visit[next[0]][next[1]] = true;
                    queue.add(new Bucket(next[0], next[1]));

                    if (next[0] == 0) { // A가 빈 경우
                        answer[next[2]] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= volume[2]; i++) {
            if (answer[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    public static class Bucket {
        int A, B;

        public Bucket(int a, int b) {
            A = a;
            B = b;
        }
    }
}
