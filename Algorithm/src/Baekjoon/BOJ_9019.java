package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        char[] commands = {'D', 'S', 'L', 'R'};

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int origin = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            Queue<Register> queue = new LinkedList<>();
            queue.add(new Register(origin, ""));

            boolean[] visit = new boolean[10000];
            visit[origin] = true;

            while (!queue.isEmpty()) {
                Register cur = queue.poll();

                if (cur.n == target) {
                    sb.append(cur.command).append("\n");
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int next = simulation(cur.n, k);

                    if (!visit[next]) {
                        queue.add(new Register(next, cur.command + commands[k]));
                        visit[next] = true;
                    }
                }
            }
        }

        System.out.println(sb);
    }

    public static int simulation(int n, int command) {
        switch (command) {
            case 0: return n * 2 % 10000;
            case 1: return n == 0 ? 9999 : n - 1;
            case 2: return n % 1000 * 10 + n / 1000;
            default: return n % 10 * 1000 + n / 10;
        }
    }

    public static class Register {
        int n;
        String command;

        public Register(int n, String command) {
            this.n = n;
            this.command = command;
        }
    }
}
