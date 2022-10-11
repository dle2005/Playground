package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int window = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'b') window++;
        }

        s += s;
        char[] arr = s.toCharArray();
        int min = Integer.MAX_VALUE;

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 'b')
                q.offer(i);

            if(!q.isEmpty() && i - q.peek() >= window)
                q.poll();

            min = Math.min(min, window - q.size());
        }

        System.out.println(min);
    }
}
