package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1022 {
    public static int r1, c1, r2, c2;
    public static int[][] map;

    public static int[] di = {0, -1, 0, 1};
    public static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        // r2 - r1 + 1 = 6, c2 - c1 + 1 = 4
        map = new int[r2 - r1 + 1][c2 - c1 + 1];

        int length = String.valueOf(bfs()).length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int num = map[i][j];

                for(int k = 0; k < length - String.valueOf(num).length(); k++)
                    sb.append(" ");
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int bfs() {
        int i = 0, j = 0;
        int num = 1, dir = 0, cnt = 0, turn = 1, fill = 0;

        while (fill < (r2-r1+1) * (c2-c1+1)) {
            if (r1 <= i && i <= r2 && c1 <= j && j <= c2) {
                map[i - r1][j - c1] = num; // i - r1 = 3, j - c1 = 3
                fill++;
            }
            
            num++; // 입력 값은 계속 증가
            cnt++; // 특정 방향에서 몇번 이동했는지

            i += di[dir]; j += dj[dir];

            if (cnt == turn) { // 방향 전환 해야 하는 경우
                cnt = 0; // 이동 수 0으로 초기화
                if(dir == 1 || dir == 3) turn++; // 좌우 이동 시 이동 수가 늘어남
                dir = (dir + 1) % 4; // 방향 전환
            }
        }

        return num - 1;
    }
}
