package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3190 {
    public static int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N+1];

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            arr[y][x] = 1;
        }

        Map<Integer, Character> map = new HashMap<>();
        int L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);

            map.put(X, C);
        }

        int cur_direction = 0;
        int i = 1, j = 1;
        int time = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        while (true) {
            i += direction[cur_direction][0];
            j += direction[cur_direction][1];
            time++;

            if(i > N || j > N || i < 1 || j < 1 || arr[i][j] == 2) // 테투리 도착시 종료
                break;

            if(arr[i][j] != 1) { // 사과가 아닌경우
                if(!q.isEmpty()) {
                    int[] t = q.pollLast();
                    arr[t[0]][t[1]] = 0;
                }
            }

            arr[i][j] = 2; // 지나가는 칸은 꼬리
            q.offerFirst(new int[]{i,j});

            if(map.containsKey(time)) {
                char d = map.get(time);
                if(d == 'D')
                    cur_direction = (cur_direction + 1) % 4;
                else
                    cur_direction = (cur_direction - 1 + 4) % 4;
            }
        }

        System.out.println(time);
    }
}
