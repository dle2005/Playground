package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] stacks = new Stack[N + 1];
        Set<Integer>[] sets = new Set[N + 1];
        for (int i = 0; i <= N; i++) {
            stacks[i] = new Stack<>();
            sets[i] = new HashSet<>();
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            while (!stacks[line].isEmpty() && stacks[line].peek() > fret) {
                int remove_fret = stacks[line].pop();
                sets[line].remove(remove_fret);

                answer++;
            }

            if (sets[line].contains(fret)) continue;

            sets[line].add(fret);
            stacks[line].add(fret);
            answer++;
        }

        System.out.println(answer);
    }
}
