package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667 {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        boolean[][] visit = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++)
                arr[i][j] = s.charAt(j) - 48;
        }

        int count = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visit[i][j] && arr[i][j] == 1) {
                    visit[i][j] = true;
                    count++;
                    int num = 1;

                    q.offer(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] top = q.poll();
                        int t_i = top[0], t_j = top[1];

                        for (int k = 0; k < 4; k++) {
                            int n_i = t_i + dx[k];
                            int n_j = t_j + dy[k];

                            if (0 <= n_i && n_i < N && 0 <= n_j && n_j < N) {
                                if (!visit[n_i][n_j] && arr[n_i][n_j] == 1) {
                                    visit[n_i][n_j] = true;
                                    q.offer(new int[]{n_i, n_j});
                                    num++;
                                }
                            }
                        }
                    }
                    list.add(num);
                }
            }
        }

        Collections.sort(list);

        System.out.println(count);
        for(int i : list)
            System.out.println(i);
    }
}
