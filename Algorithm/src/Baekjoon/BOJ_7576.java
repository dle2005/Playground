package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        int cnt = M * N;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    queue.add(new Node(i, j));
                    visit[i][j] = true;
                    cnt--;
                } else if (map[i][j] == -1) {
                    cnt--;
                }
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int answer = 0;
        while (!queue.isEmpty()) {
            if (cnt == 0) {
                System.out.println(answer);
                return;
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (visit[nx][ny] || map[nx][ny] == -1) continue;

                    queue.add(new Node(nx, ny));
                    visit[nx][ny] = true;
                    cnt--;
                }
            }

            answer++;
        }

        System.out.println(-1);
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
