package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[M][N];

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++)
                    map[i][j] = true;
            }
        }



        List<Integer> list = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!map[i][j]) {
                    int cnt = 0;
                    queue.offer(new int[]{i, j});
                    map[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        cnt++;

                        for (int k = 0; k < 4; k++) {
                            int ii = cur[0] + di[k];
                            int jj = cur[1] + dj[k];

                            if (ii < 0 || jj < 0 || ii >= M || jj >= N) continue;
                            if (map[ii][jj]) continue;

                            queue.offer(new int[]{ii, jj});
                            map[ii][jj] = true;
                        }
                    }

                    list.add(cnt);
                }
            }
        }

        System.out.println(list.size());

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int cnt : list) sb.append(cnt).append(" ");

        System.out.println(sb);
    }
}
