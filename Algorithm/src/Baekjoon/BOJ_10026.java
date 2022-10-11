package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {
    public static boolean[][] visit;
    public static char[][] case1;
    public static char[][] case2;
    public static int[] di = {0, 1, 0, -1};
    public static int[] dj = {1, 0, -1, 0};
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        case1 = new char[N][N];
        case2 = new char[N][N];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                char c = s.charAt(j);
                case1[i][j] = c;
                if(c == 'R')
                    case2[i][j] = 'G';
                else
                    case2[i][j] = c;
            }
        }

        visit = new boolean[N][N];
        int count1 = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visit[i][j]) {
                    bfs(i, j, case1);
                    count1++;
                }
            }
        }

        visit = new boolean[N][N];
        int count2 = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visit[i][j]) {
                    bfs(i, j, case2);
                    count2++;
                }
            }
        }

        System.out.println(count1 + " " + count2);
    }

    public static void bfs(int i, int j, char[][] cases) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visit[i][j] = true;

        char start = cases[i][j];

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();

            for(int k = 0; k < 4; k++) {
                int ii = temp[0] + di[k];
                int jj = temp[1] + dj[k];

                if(0 <= ii && ii < N && 0 <= jj && jj < N && !visit[ii][jj] && cases[ii][jj] == start) {
                    queue.offer(new int[]{ii, jj});
                    visit[ii][jj] = true;
                }
            }
        }
    }
}
