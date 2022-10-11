package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push_front" :
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back" :
                    deque.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" :
                    if(deque.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(deque.poll()).append('\n');
                    break;
                case "pop_back" :
                    if(deque.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(deque.pollLast()).append('\n');
                    break;
                case "size" :
                    sb.append(deque.size()).append('\n');
                    break;
                case "empty" :
                    if(deque.isEmpty())
                        sb.append(1).append('\n');
                    else
                        sb.append(0).append('\n');
                    break;
                case "front" :
                    if(deque.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(deque.peek()).append('\n');
                    break;
                case "back" :
                    if(deque.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(deque.peekLast()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
}
