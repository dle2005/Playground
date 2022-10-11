package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 수빈이가 있는 위치
        int M = Integer.parseInt(st.nextToken()); // 동생이 있는 위치

        Queue<int []> queue = new LinkedList<>();
        boolean[] visit = new boolean[100001];

        queue.offer(new int[]{N, 0}); // 수빈이의 위치, 이동 횟수


        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            visit[q[0]] = true;

            if(q[0] == M) { // 동생을 찾은 경우
                System.out.println(q[1]);
                System.exit(0);
            }

            if(q[0] < M && q[0] * 2 <= 100000 && !visit[q[0] * 2])
                queue.offer(new int[]{q[0] * 2, q[1] + 1});
            if(q[0] < M && !visit[q[0] + 1])
                queue.offer(new int[]{q[0] + 1, q[1] + 1});
            if(q[0] > 0 && !visit[q[0] - 1])
                queue.offer(new int[]{q[0] - 1, q[1] + 1});
        }
    }
}
