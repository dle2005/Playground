package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<int[]> tower = new Stack<>();
        Stack<int[]> raiser = new Stack<>();
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            tower.push(new int[]{t, i});
        }

        while(!tower.isEmpty()) {
            int[] t = tower.pop();

            while(!raiser.isEmpty() && raiser.peek()[0] < t[0]) {
                int[] r = raiser.pop();
                arr[r[1]] = t[1] + 1;
            }

            raiser.push(t);
        }

        for(int i : arr)
            System.out.print(i + " ");
    }
}
