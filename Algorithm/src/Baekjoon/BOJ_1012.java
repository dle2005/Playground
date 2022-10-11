package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1012 {
    public static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {1, 0, -1, 0};
    public static boolean[][] arr = new boolean[51][51];
    public static int M, N, K, count, x, y, xx, yy, T;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            List<int[]> list = new ArrayList<>();
            count = 0;

            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                arr[y][x] = true;
                list.add(new int[]{y, x});
            }

            for(int[] cabbage : list) {
                y = cabbage[0];
                x = cabbage[1];

                if(arr[y][x] == false) continue;

                arr[y][x] = false;
                Queue<int[]> q = new LinkedList<>();
                q.offer(cabbage);

                while(!q.isEmpty()) {
                    int[] t = q.poll();

                    for(int k = 0; k < 4; k++) {
                        yy = t[0] + dy[k];
                        xx = t[1] + dx[k];

                        if(0 <= yy && yy < N && 0 <= xx && xx < M && arr[yy][xx] == true) {
                            q.offer(new int[]{yy, xx});
                            arr[yy][xx] = false;
                        }
                    }
                }

                count++;
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
