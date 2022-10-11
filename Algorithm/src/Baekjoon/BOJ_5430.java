package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String[] s = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().replace("[", "")
                    .replace("]", "").split(",");

            Deque<String> deque = new ArrayDeque<>();
            for(String t : arr)
                deque.push(t);

            boolean direction = true;
            boolean error = false;

            for(String t : s) {
                if(t.equals("R"))
                    direction = !direction;
                else {
                    if(deque.isEmpty() || n == 0) {
                        sb.append("error").append("\n");
                        error = true;
                        break;
                    }
                    if (direction)
                        deque.pollLast();
                    else
                        deque.pollFirst();
                }
            }

            if(!error) {
                sb.append("[");
                if (direction) {
                    while (deque.size() > 1)
                        sb.append(deque.pollLast()).append(",");
                } else {
                    while (deque.size() > 1)
                        sb.append(deque.pollFirst()).append(",");
                }

                if(deque.isEmpty())
                    sb.append("]").append("\n");
                else
                    sb.append(deque.poll()).append("]").append("\n");
            }
        }

        System.out.println(sb);
    }
}
