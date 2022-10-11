package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class P_67259 {
    public static void main(String[] args) {
        // 경주로 부지는 N * N 크기의 정사각형 격자 형태
        // 각 격자의 칸은 0 또는 1, 0은 칸이 비어 있음, 1은 벽으로 채워져 있음
        // 출발점은 (0,0)칸 도착점은 (N-1,N-1)칸
        // 중간에 끊기지 않도록 경주로를 건설
        // 상, 하, 좌, 우로 인접한 두 빈 칸을 연결하여 건설 가능
        // 상하 또는 좌우로 연결한 경주로를 직선 도로, 100원 소요
        // 직선도로가 서로 직각으로 만나는 지점을 코너, 500원 소요
        // 경주로를 건설하는 데 필요한 최소 비용
        solution(new int[][]{{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}});
    }
    public static int solution(int[][] board) {
        int answer = 0;

        int N = board.length; // 경주로 부지의 크기

        int[] di = new int[]{0, 1, 0, -1}; // 상하좌우 이동
        int[] dj = new int[]{1, 0, -1, 0};

        int[][] map = new int[N][N];
        Queue<int[]> queue = new LinkedList<>();

        // 출발점 (0,0), 건설 비용, 방향
        queue.offer(new int[]{0, 0, 0, -1});
        board[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] q = queue.poll();

            for(int k = 0; k < 4; k++) {
                int i = q[0] + di[k]; // 방향 이동
                int j = q[1] + dj[k];

                // 지도 밖으로 벗어나는 경우
                if(i < 0 || j < 0 || i >= N || j >= N || board[i][j] == 1) continue;

                int cost = 0;
                // 방향이 k랑 같다면 같은 방향에서 온것
                if(q[3] == -1 || q[3] == k) cost = q[2] + 100;
                else if(q[3] != k) cost = q[2] + 600;

                // 이미 방문한 경우 새로운 값이 더 작다면 가능
                if(map[i][j] == 0) {
                    map[i][j] = cost;
                    queue.offer(new int[]{i, j, cost, k});
                }
                else if(map[i][j] >= cost) {
                    map[i][j] = cost;
                    queue.offer(new int[]{i, j, cost, k});
                }
            }
        }

        return answer = map[N-1][N-1];
    }
}
